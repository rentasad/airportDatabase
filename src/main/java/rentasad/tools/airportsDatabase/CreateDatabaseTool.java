package rentasad.tools.airportsDatabase;

import java.io.IOException;
import java.sql.Connection;
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

public class CreateDatabaseTool {
	
	
	public void createDatabase() throws SQLException, IOException, AlertException, SqlExecutionToolException, ConfigFileToolException
	{
		String filename = "resources/config/configSqlExecution.ini";
		Map<String, Map<String, String>> configMapMap = ConfigFileTool.readIniFileWithAllSections(filename);
		Connection con = MYSQLConnection.dbConnect(configMapMap.get("MYSQL_CONFIG"));
		
		SqlFileExecutionTool tool = new SqlFileExecutionTool(configMapMap);
		List<SqlExecutionObject> sqlObjectList = tool.getSqlExecutionObjectList();
		SqlExecutionObject sqlExObj = sqlObjectList.get(0); 
		SqlFileExecutionTool.executeExecutionQuery(sqlExObj, con);
		
	}
}
