package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.sql.SQLException;

import rentasad.library.configFileTool.ConfigFileToolException;
import rentasad.library.db.sqlExecutionTool.SqlExecutionToolException;
import rentasad.library.tools.exceptions.guiExceptions.AlertException;

public class createAirportDatabaseMain {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDatabaseTool tool = new CreateDatabaseTool();
		try {
			// Erstellen der Datenbankstruktur
			tool.createDatabase();
		} catch (SQLException | IOException | AlertException | SqlExecutionToolException | ConfigFileToolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
