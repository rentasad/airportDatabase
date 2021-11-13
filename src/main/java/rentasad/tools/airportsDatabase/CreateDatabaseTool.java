package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import rentasad.library.configFileTool.ConfigFileTool;
import rentasad.library.configFileTool.ConfigFileToolException;
import rentasad.library.db.MYSQLConnection;
import rentasad.library.db.sqlExecutionTool.SqlExecutionToolException;
import rentasad.library.db.sqlExecutionTool.SqlFileExecutionTool;
import rentasad.library.db.sqlExecutionTool.objects.SqlExecutionObject;
import rentasad.tools.airportsDatabase.objects.AirportFrequenciesObjects;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
import rentasad.tools.airportsDatabase.objects.CountriesObject;
import rentasad.tools.airportsDatabase.objects.NavaidsObject;
import rentasad.tools.airportsDatabase.objects.RegionsObject;
import rentasad.tools.airportsDatabase.objects.RunwaysObject;

public class CreateDatabaseTool {

	private Connection con;
	private Map<String, Map<String, String>> configMapMap;
	private String filename;

	public CreateDatabaseTool() throws ConfigFileToolException, SQLException {
		super();
		filename = "resources/config/configSqlExecution.ini";
		configMapMap = ConfigFileTool.readIniFileWithAllSections(filename);
		con = MYSQLConnection.dbConnect(configMapMap.get("MYSQL_CONFIG"));
	}

	public void createDatabase()
			throws SQLException, IOException, SqlExecutionToolException, ConfigFileToolException {

		SqlFileExecutionTool tool = new SqlFileExecutionTool(configMapMap);
		List<SqlExecutionObject> sqlObjectList = tool.getSqlExecutionObjectList();
		SqlExecutionObject sqlExObj = sqlObjectList.get(0);
		SqlFileExecutionTool.executeExecutionQuery(sqlExObj, con);

	}

	/**
	 * 
	 *
	 * @param airportObjectList
	 * @throws SQLException 
	 */
	public void addAirports(List<AirportsObject> airportObjectList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO airports (id,\n"
				+ "ident,\n"
				+ "type,\n"
				+ "name,\n"
				+ "latitude_deg,\n"
				+ "longitude_deg,\n"
				+ "elevation_ft,\n"
				+ "continent,\n"
				+ "iso_country,\n"
				+ "iso_region,\n"
				+ "municipality,\n"
				+ "scheduled_service,\n"
				+ "gps_code,\n"
				+ "iata_code,\n"
				+ "local_code,\n"
				+ "home_link,\n"
				+ "wikipedia_link,\n"
				+ "keywords\n"
				+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		int line = 0;
		int col = 1;
		for (AirportsObject ao : airportObjectList) {
			line++;
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
			ps.setBoolean(col++, ao.isScheduled_service());
			ps.setString(col++, ao.getGps_code());
			ps.setString(col++, ao.getIata_code());
			ps.setString(col++, ao.getLocal_code());
			ps.setString(col++, ao.getHome_link());
			ps.setString(col++, ao.getWikipedia_link());
			ps.setString(col++, ao.getKeywords());
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + airportObjectList.size());
				ps.executeBatch();
			}
		}
		ps.executeBatch();
		ps.close();
	}
	
	/**
	 * 
	 * @param airportFrequenciesList
	 * @throws SQLException
	 */
	public void addAirportFrequencies(List<AirportFrequenciesObjects> airportFrequenciesList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO airport_frequencies ("
				+ "ID,\n"
				+ "AIRPORT_REF,\n"
				+ "AIRPORT_IDENT,\n"
				+ "TYPE,\n"
				+ "DESCRIPTION,\n"
				+ "FREQUENCY_MHZ\n"
				
							+ ") VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		int line = 0;
		int col = 1;
		for (AirportFrequenciesObjects ao : airportFrequenciesList) {
			line++;
			ps.setLong(col++, ao.getId());
			ps.setLong(col++, ao.getAirport_ref());
			ps.setString(col++, ao.getAirport_ident());
			ps.setString(col++, ao.getType());
			ps.setString(col++, ao.getDescription());
			ps.setString(col++, ao.getFrequency_mhz());
	
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + airportFrequenciesList.size());
				ps.executeBatch();
			}
			
		}
		ps.executeBatch();
		ps.close();
		
		
	}
	
	/**
	 * 
	 * @param countriesObjectList
	 * @throws SQLException
	 */
	public void addCountries(List<CountriesObject> countriesObjectList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO countries ("
				+ "ID,\n"
				+ "CODE,\n"
				+ "NAME,\n"
				+ "CONTINENT,\n"
				+ "WIKIPEDIA_LINK,\n"
				+ "KEYWORDS\n"
							+ ") VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		int line = 0;
		int col = 1;
		for (CountriesObject ao : countriesObjectList) {
			line++;
			ps.setLong(col++, ao.getId());
			ps.setString(col++, ao.getCode());
			ps.setString(col++, ao.getName());
			ps.setString(col++, ao.getContinent());
			ps.setString(col++, ao.getWikipedia_link());
			ps.setString(col++, ao.getKeywords());
			
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + countriesObjectList.size());
				ps.executeBatch();
			}
			
		}
		ps.executeBatch();
		ps.close();
	}
	/**
	 * 
	 * @param regionsObjectList
	 * @throws SQLException
	 */
	public void addRegions(List<RegionsObject> regionsObjectList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO regions ("
				+ "id,\n"
				+ "code,\n"
				+ "local_code,\n"
				+ "name,\n"
				+ "continent,\n"
				+ "iso_country,\n"
				+ "wikipedia_link,\n"
				+ "keywords\n"
							+ ") VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		int line = 0;
		int col = 1;
		for (RegionsObject ao : regionsObjectList) {
			line++;
			ps.setLong(col++, ao.getId());
			ps.setString(col++, ao.getCode());
			ps.setString(col++, ao.getLocal_code());
			ps.setString(col++, ao.getName());
			ps.setString(col++, ao.getContinent());
			ps.setString(col++, ao.getIso_country());
			ps.setString(col++, ao.getWikipedia_link());
			ps.setString(col++, ao.getKeywords());
	
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + regionsObjectList.size());
				ps.executeBatch();
			}
			
		}
		ps.executeBatch();
		ps.close();
	}
	
	public void addRunways(List<RunwaysObject> runwayObjectList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO runways ("
				+ "id,\n"
				+ "airport_ref,\n"
				+ "airport_ident,\n"
				+ "length_ft,\n"
				+ "width_ft,\n"
				+ "surface,\n"
				+ "lighted,\n"
				+ "closed,\n"
				+ "le_ident,\n"
				+ "le_latitude_deg,\n"
				+ "le_longitude_deg,\n"
				+ "le_elevation_ft,\n"
				+ "le_heading_degT,\n"
				+ "le_displaced_threshold_ft,\n"
				+ "he_ident,\n"
				+ "he_latitude_deg,\n"
				+ "he_longitude_deg,\n"
				+ "he_elevation_ft,\n"
				+ "he_heading_degT,\n"
				+ "he_displaced_threshold_ft\n"
				+ ""
							+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		int line = 0;
		int col = 1;
		for (RunwaysObject ao : runwayObjectList) {
			line++;
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
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + runwayObjectList.size());
				ps.executeBatch();
			}
		}
		ps.executeBatch();
		ps.close();
	}
	
	public void addNavaids(List<NavaidsObject> navaidObjectList) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "INSERT INTO navaids ("
				+ "ID,\n"
				+ "FILENAME,\n"
				+ "IDENT,\n"
				+ "NAME,\n"
				+ "TYPE,\n"
				+ "FREQUENCY_KHZ,\n"
				+ "LATITUDE_DEG,\n"
				+ "LONGITUDE_DEG,\n"
				+ "ELEVATION_FT,\n"
				+ "ISO_COUNTRY,\n"
				+ "DME_FREQUENCY_KHZ,\n"
				+ "DME_CHANNEL,\n"
				+ "DME_LATITUDE_DEG,\n"
				+ "DME_LONGITUDE_DEG,\n"
				+ "DME_ELEVATION_FT,\n"
				+ "SLAVED_VARIATION_DEG,\n"
				+ "MAGNETIC_VARIATION_DEG,\n"
				+ "USAGETYPE,\n"
				+ "POWER,\n"
				+ "ASSOCIATED_AIRPORT\n"
							+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		
		int line = 0;
		int col = 1;
		for (NavaidsObject ao : navaidObjectList) {
			line++;
			ps.setLong(  col++, ao.getId());
			ps.setString(col++, ao.getFilename());
			ps.setString(col++, ao.getIdent());
			ps.setString(col++, ao.getName());
			ps.setString(col++, ao.getType());
			ps.setInt(   col++, ao.getFrequency_khz());
			ps.setString(col++, ao.getLatitude_deg());
			ps.setString(col++, ao.getLongitude_deg());
			ps.setInt(   col++, ao.getElevation_ft());
			ps.setString(col++, ao.getIso_country());
			ps.setInt(   col++, ao.getDme_frequency_khz());
			ps.setString(col++, ao.getDme_channel());
			ps.setString(col++, ao.getDme_latitude_deg());
			ps.setString(col++, ao.getDme_longitude_deg());
			ps.setInt(   col++, ao.getDme_elevation_ft());
			ps.setString(col++, ao.getSlaved_variation_deg());
			ps.setString(col++, ao.getMagnetic_variation_deg());
			ps.setString(col++, ao.getUsageType());
			ps.setString(col++, ao.getPower());
			ps.setString(col++, ao.getAssociated_airport());
	
			ps.addBatch();
			ps.clearParameters();
			col=1;
			if (line % 4000 == 0)
			{
				// Alle 4000 Datensätze in DB schreiben
				System.out.println(line + " / " + navaidObjectList.size());
				ps.executeBatch();
			}
			
		}
		ps.executeBatch();
		ps.close();
		
		
	}
	
}
