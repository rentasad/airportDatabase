package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import lombok.extern.java.Log;
import rentasad.library.configFileTool.ConfigFileTool;
import rentasad.library.configFileTool.ConfigFileToolException;
import rentasad.library.db.MYSQLConnection;
import rentasad.library.db.sqlExecutionTool.SqlExecutionToolException;
import rentasad.library.db.sqlExecutionTool.SqlFileExecutionTool;
import rentasad.library.db.sqlExecutionTool.objects.SqlExecutionObject;
import rentasad.tools.airportsDatabase.model.AirportFrequenciesObject;
import rentasad.tools.airportsDatabase.model.AirportsObject;
import rentasad.tools.airportsDatabase.model.CountriesObject;
import rentasad.tools.airportsDatabase.model.NavaidsObject;
import rentasad.tools.airportsDatabase.model.RegionsObject;
import rentasad.tools.airportsDatabase.model.RunwaysObject;

/**
 * Utility class for creating and populating a database with aviation-related data.
 * This class provides methods to execute SQL scripts and batch insert data into
 * various database tables such as airports, airport frequencies, countries, regions,
 * runways, and navaids.
 *
 * The class reads database configuration from an INI file and establishes a
 * connection to a MySQL database. It also utilizes prepared statements and batch
 * processing to insert large datasets efficiently.
 *
 * This class is intended to be used for database initialization and data import purposes.
 */
@Log
public class AirportDatabaseTool {

	private Connection con;
	private Map<String, Map<String, String>> configMapMap;
	private String filename;

	public AirportDatabaseTool() throws ConfigFileToolException, SQLException {
		super();
		filename = "resources/config/configSqlExecution.ini";
		configMapMap = ConfigFileTool.readIniFileWithAllSections(filename);
		con = MYSQLConnection.dbConnect(configMapMap.get("MYSQL_CONFIG"));
	}

	/**
	 * Generic batch insert method.
	 */
	private <T> void addObjects(List<T> objectList, String sql, BiConsumer<PreparedStatement, T> binder)
			throws SQLException {
		log.info(String.format("Inserting %d records into database...", objectList.size()));
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			int line = 0;
			for (T obj : objectList) {
				line++;
				binder.accept(ps, obj);
				ps.addBatch();
				ps.clearParameters();
				if (line % 4000 == 0) {
					log.info(String.format("Inserted %d / %d records", line, objectList.size()));
					ps.executeBatch();
				}
			}
			ps.executeBatch();
		}
	}

	public void createDatabase()
			throws SQLException, IOException, SqlExecutionToolException, ConfigFileToolException {

		SqlFileExecutionTool tool = new SqlFileExecutionTool(configMapMap);
		List<SqlExecutionObject> sqlObjectList = tool.getSqlExecutionObjectList();
		SqlExecutionObject sqlExObj = sqlObjectList.get(0);
		SqlFileExecutionTool.executeExecutionQuery(sqlExObj, con);

	}

	public void addAirports(List<AirportsObject> airportObjectList) throws SQLException {
		String insertQuery = """
				INSERT INTO airports (id, ident, type, name, latitude_deg, longitude_deg, elevation_ft, continent,
				iso_country, iso_region, municipality, scheduled_service, gps_code, iata_code, local_code,
				home_link, wikipedia_link, keywords
				) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)""";

		addObjects(airportObjectList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setLong(col++, ao.getId());
				ps.setString(col++, ao.getIdent());
				ps.setString(col++, ao.getType());
				ps.setString(col++, ao.getName());
				ps.setString(col++, ao.getLatitude_deg());
				ps.setString(col++, ao.getLongitude_deg());
				ps.setInt(col++, ao.getElevation_ft());
				ps.setString(col++, ao.getContinent());
				ps.setString(col++, ao.getIso_country());
				ps.setString(col++, ao.getIso_region());
				ps.setString(col++, ao.getMunicipality());
				ps.setBoolean(col++, ao.getScheduled_service());
				ps.setString(col++, ao.getGps_code());
				ps.setString(col++, ao.getIata_code());
				ps.setString(col++, ao.getLocal_code());
				ps.setString(col++, ao.getHome_link());
				ps.setString(col++, ao.getWikipedia_link());
				ps.setString(col++, ao.getKeywords());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void addAirportFrequencies(List<AirportFrequenciesObject> airportFrequenciesList) throws SQLException {
		String insertQuery = "INSERT INTO airport_frequencies (ID, AIRPORT_REF, AIRPORT_IDENT, TYPE, DESCRIPTION, FREQUENCY_MHZ) VALUES (?,?,?,?,?,?)";
		addObjects(airportFrequenciesList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setLong(col++, ao.getId());
				ps.setLong(col++, ao.getAirport_ref());
				ps.setString(col++, ao.getAirport_ident());
				ps.setString(col++, ao.getType());
				ps.setString(col++, ao.getDescription());
				ps.setString(col++, ao.getFrequency_mhz());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void addCountries(List<CountriesObject> countriesObjectList) throws SQLException {
		String insertQuery = "INSERT INTO countries (ID, CODE, NAME, CONTINENT, WIKIPEDIA_LINK, KEYWORDS) VALUES (?,?,?,?,?,?)";
		addObjects(countriesObjectList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setLong(col++, ao.getId());
				ps.setString(col++, ao.getCode());
				ps.setString(col++, ao.getName());
				ps.setString(col++, ao.getContinent());
				ps.setString(col++, ao.getWikipedia_link());
				ps.setString(col++, ao.getKeywords());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void addRegions(List<RegionsObject> regionsObjectList) throws SQLException {
		String insertQuery = "INSERT INTO regions (id, code, local_code, name, continent, iso_country, wikipedia_link, keywords) VALUES (?,?,?,?,?,?,?,?)";
		addObjects(regionsObjectList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setLong(col++, ao.getId());
				ps.setString(col++, ao.getCode());
				ps.setString(col++, ao.getLocal_code());
				ps.setString(col++, ao.getName());
				ps.setString(col++, ao.getContinent());
				ps.setString(col++, ao.getIso_country());
				ps.setString(col++, ao.getWikipedia_link());
				ps.setString(col++, ao.getKeywords());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void addRunways(List<RunwaysObject> runwayObjectList) throws SQLException {
		String insertQuery = "INSERT INTO runways (id, airport_ref, airport_ident, length_ft, width_ft, surface, lighted, closed, le_ident, le_latitude_deg, le_longitude_deg, le_elevation_ft, le_heading_degT, le_displaced_threshold_ft, he_ident, he_latitude_deg, he_longitude_deg, he_elevation_ft, he_heading_degT, he_displaced_threshold_ft) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		addObjects(runwayObjectList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setInt(col++, ao.getId());
				ps.setInt(col++, ao.getAirport_ref());
				ps.setString(col++, ao.getAirport_ident());
				ps.setInt(col++, ao.getLength_ft());
				ps.setInt(col++, ao.getWidth_ft());
				ps.setString(col++, ao.getSurface());
				ps.setBoolean(col++, ao.isLighted());
				ps.setBoolean(col++, ao.isClosed());
				ps.setString(col++, ao.getLe_ident());
				ps.setString(col++, ao.getLe_latitude_deg());
				ps.setString(col++, ao.getLe_longitude_deg());
				ps.setInt(col++, ao.getLe_elevation_ft());
				ps.setString(col++, ao.getLe_heading_degT());
				ps.setInt(col++, ao.getLe_displaced_threshold_ft());
				ps.setString(col++, ao.getHe_ident());
				ps.setString(col++, ao.getHe_latitude_deg());
				ps.setString(col++, ao.getHe_longitude_deg());
				ps.setInt(col++, ao.getHe_elevation_ft());
				ps.setString(col++, ao.getHe_heading_degT());
				ps.setInt(col++, ao.getHe_displaced_threshold_ft());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void addNavaids(List<NavaidsObject> navaidObjectList) throws SQLException {
		String insertQuery = "INSERT INTO navaids (ID, FILENAME, IDENT, NAME, TYPE, FREQUENCY_KHZ, LATITUDE_DEG, LONGITUDE_DEG, ELEVATION_FT, ISO_COUNTRY, DME_FREQUENCY_KHZ, DME_CHANNEL, DME_LATITUDE_DEG, DME_LONGITUDE_DEG, DME_ELEVATION_FT, SLAVED_VARIATION_DEG, MAGNETIC_VARIATION_DEG, USAGETYPE, POWER, ASSOCIATED_AIRPORT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		addObjects(navaidObjectList, insertQuery, (ps, ao) -> {
			try {
				int col = 1;
				ps.setLong(col++, ao.getId());
				ps.setString(col++, ao.getFilename());
				ps.setString(col++, ao.getIdent());
				ps.setString(col++, ao.getName());
				ps.setString(col++, ao.getType());
				ps.setInt(col++, ao.getFrequency_khz());
				ps.setString(col++, ao.getLatitude_deg());
				ps.setString(col++, ao.getLongitude_deg());
				ps.setInt(col++, ao.getElevation_ft());
				ps.setString(col++, ao.getIso_country());
				ps.setInt(col++, ao.getDme_frequency_khz());
				ps.setString(col++, ao.getDme_channel());
				ps.setString(col++, ao.getDme_latitude_deg());
				ps.setString(col++, ao.getDme_longitude_deg());
				ps.setInt(col++, ao.getDme_elevation_ft());
				ps.setString(col++, ao.getSlaved_variation_deg());
				ps.setString(col++, ao.getMagnetic_variation_deg());
				ps.setString(col++, ao.getUsageType());
				ps.setString(col++, ao.getPower());
				ps.setString(col++, ao.getAssociated_airport());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
