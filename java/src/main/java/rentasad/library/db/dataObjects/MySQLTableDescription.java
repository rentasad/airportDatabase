package rentasad.library.db.dataObjects;

import lombok.Data;
import java.util.Date;
/**
 * 
 * @author mst
 *
 *
 * Die unten beschriebenen Felder werden durch folgende Abfrage ausgegeben:
 * 
 * show table status  from [datenbankname]
 *
 */
@Data
public class MySQLTableDescription implements IsqlTableDescriptionInterface
{
	String name;
	String engine;
	int version;
	String rowFormat;
	double rows;
	double avgRowLength;
	int data_length;
	int maxDataLength;
	int indexLength;
	int dataFree;
	long autoIncrement;
	Date createTime;
	Date updateTime;
	Date checkTime;
	String collation;
	String checksum;
	String createOptions;
	String comment;

	String[] HeaderNames =
	{
			"Name",
			"Engine",
			"Version",
			"Row_format",
			"Rows",
			"Avg_row_length",
			"Data_length",
			"Max_data_length",
			"Index_length",
			"Data_free",
			"Auto_increment",
			"Create_time",
			"Update_time",
			"Check_time",
			"Collation",
			"Checksum",
			"Create_options",
			"Comment" };

}
