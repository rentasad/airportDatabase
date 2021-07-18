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
import rentasad.library.tools.exceptions.guiExceptions.AlertException;
import rentasad.tools.airportsDatabase.objects.AirportsObject;

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
			throws SQLException, IOException, AlertException, SqlExecutionToolException, ConfigFileToolException {

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
}
