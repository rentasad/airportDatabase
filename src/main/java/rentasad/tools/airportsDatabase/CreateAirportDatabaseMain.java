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
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AirportDatabaseTool tool = new AirportDatabaseTool();
			AirportImportService importService = new AirportImportService(tool);
			importService.importData();
			log.info("Fertig.");
		} catch (Exception e) {
			log.severe("Fehler beim Importieren der Daten: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
