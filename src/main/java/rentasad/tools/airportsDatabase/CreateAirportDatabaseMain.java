package rentasad.tools.airportsDatabase;

import lombok.extern.java.Log;

/**
 * 
 * @author matthi
 *
 */
@Log
public class CreateAirportDatabaseMain {

	/**
	 * Entry point for the application. Initializes the necessary tools and services
	 * to import airport data and logs the process.
	 *
	 * @param args the command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		try {
			AirportDatabaseTool tool = new AirportDatabaseTool();
			AirportImportService importService = new AirportImportService(tool);
			importService.importData();
			log.info("Done.");
		} catch (Exception e) {
			log.severe("Error importing data: " + e.getMessage());
		}
	}

}
