package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import rentasad.library.basicTools.DownloadAirportFilesModul;
import rentasad.library.configFileTool.ConfigFileToolException;
import rentasad.library.db.sqlExecutionTool.SqlExecutionToolException;
import rentasad.tools.airportsDatabase.objects.AirportFrequenciesObjects;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
import rentasad.tools.airportsDatabase.objects.CountriesObject;
import rentasad.tools.airportsDatabase.objects.NavaidsObject;
import rentasad.tools.airportsDatabase.objects.RegionsObject;
import rentasad.tools.airportsDatabase.objects.RunwaysObject;
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
			
			DownloadAirportFilesModul.airportFileDownloader();
			
			CreateDatabaseTool tool = new CreateDatabaseTool();
			ParseAirportCsvFilesModul parseModul = new ParseAirportCsvFilesModul();
			System.out.println("Parse Airports.CSV");
			List<AirportsObject> airportObjectList = parseModul.parseAirportCsv("resources/download/airports.csv");
			System.out.println("Parse Airport-Frequencies");
			List<AirportFrequenciesObjects> airportFrequenciesObjectList = parseModul.parseAirportFrequenciesCsv("resources/download/airport-frequencies.csv");
			System.out.println("Parse Countries");
			List<CountriesObject> countriesObjectList = parseModul.parseCountriesCsv("resources/download/countries.csv");
			System.out.println("Navaids");
			List<NavaidsObject> navaidsObjectList= parseModul.parseNavaidsCsv("resources/download/navaids.csv");
			System.out.println("Regions");
			List<RegionsObject> regionsObjectList = parseModul.parseRegionsCsv("resources/download/regions.csv");
			System.out.println("Runways");
			List<RunwaysObject> runwayObjectList = parseModul.parseRunwayCsv("resources/download/runways.csv");
			
			// Erstellen der Datenbankstruktur
			tool.createDatabase();
			System.out.println("Lege Airports in DB an");
			tool.addAirports(airportObjectList);
			System.out.println("Lege Airport-Frequencies an");
			tool.addAirportFrequencies(airportFrequenciesObjectList);
			System.out.println("Lege Countries an");
			tool.addCountries(countriesObjectList);
			
			System.out.println("Lege Runways an");
			tool.addRunways(runwayObjectList);
			System.out.println("Lege Regions an");
			tool.addRegions(regionsObjectList);
			
			System.out.println("Lege Navaids an");
			tool.addNavaids(navaidsObjectList);
			System.out.println("Fertig.");
		} catch (IOException | CsvException | URISyntaxException | SQLException | ConfigFileToolException  | SqlExecutionToolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
