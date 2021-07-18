package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import rentasad.library.configFileTool.ConfigFileToolException;
import rentasad.library.db.sqlExecutionTool.SqlExecutionToolException;
import rentasad.library.tools.exceptions.guiExceptions.AlertException;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
/**
 * 
 * @author matthi
 *
 */
public class createAirportDatabaseMain {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Parse Airports.CSV");
			CreateDatabaseTool tool = new CreateDatabaseTool();
			ParseAirportCsvFilesModul parseModul = new ParseAirportCsvFilesModul();
			List<AirportsObject> airportObjectList = parseModul.parseAirportCsv("resources/download/airports.csv");
			// Erstellen der Datenbankstruktur
			tool.createDatabase();
			System.out.println("Lege Airports in DB an");
			tool.addAirports(airportObjectList);
			System.out.println("Fertig.");
		} catch (IOException | CsvException | URISyntaxException | SQLException | ConfigFileToolException | AlertException | SqlExecutionToolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
