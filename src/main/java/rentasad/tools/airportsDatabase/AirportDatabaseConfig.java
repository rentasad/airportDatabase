package rentasad.tools.airportsDatabase;

/**
 * Central configuration constants for the airport database import tool.
 */
public final class AirportDatabaseConfig {

	private AirportDatabaseConfig() {
	}

	public static final String CONFIG_SQL_EXECUTION = "resources/config/configSqlExecution.ini";
	public static final String CONFIG_DOWNLOAD_LINKS = "resources/config/downloadLinks.ini";
	public static final String DOWNLOAD_DIR = "resources/download/";
	public static final String SECTION_AIRPORT_URLS = "AIRPORT_URLS";
}
