package rentasad.library.db.dataObjects;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * 
 * @author mst
 *         Datenobjekt, welches bei folgender SQL-Abfrage zurueckkommt:
 * 
 *         show full fields from v2la1001
 * 
 *         Mit diesem Datenmodell wird die Struktur einer MySQL-Tabelle
 *         ausgegeben und beschrieben.
 *         Fuer jedes Feld einer Tabelle wird der Datentyp zurueckgegeben, welcher
 *         dieses Feld beschreibt.
 */
@Data
public class MySQLTableColumnDescription implements ISQLTableColumnsDescriptionInterface
{
	
	
	
	String field;
	int type;
	String collation;
	int length = LENGTH_IS_NOT_DEFINED;
	boolean canBeNull;
	String key;
	String extra;
	String privileges;
	String comment;
	int defaultInt;
	double defaultDouble;
	String defaultString;
	Date defaultDate;
	Time defaultTime;
	boolean defaultBoolean;
	boolean LengthDefined;

	/**
	 * MYSQL hat sehr viele verschiedene Datentypen. Diese werden auf bestimmte
	 * Java Datentypen umgesetzt. Die Entscheidung, welcher Datentyp wie in Java
	 * umgesetzt wird, geschieht in dieser Funktion
	 * 
	 * @param typ
	 *            ISQLTableColumnsDescriptionInterface.DATATYPE_[...]
	 * 
	 * @return ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_[...]
	 */
	public int getJavaDatatypeFromISQLTyp(int typ)
	{
		int dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_UNDEFINED;

		if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_STRING_VARCHAR
					|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_STRING_LONGTEXT)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_STRING;
		} else if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_DATE_DATE
					|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_DATE_DATETIME
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_DATE_TIME
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_DATE_TIMESTAMP)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_DATE;

		} else if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_BIGINT
					|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_BIT
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_DECIMAL
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_INT
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_MEDIUMINT
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_SMALLINT
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_TINYINT
						|| typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_INT)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_INT;
		} else if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_DOUBLE)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_DOUBLE;
		} else if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_FLOAT)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_FLOAT;
		} else if (typ == ISQLTableColumnsDescriptionInterface.DATATYPE_NUM_BOOL)
		{
			dataType = ISQLTableColumnsDescriptionInterface.OBJECT_DATA_TYPE_BOOLEAN;
		}

		return dataType;

	}

	public boolean isLengthDefined()
	{
		if (this.length == LENGTH_IS_NOT_DEFINED)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
}
