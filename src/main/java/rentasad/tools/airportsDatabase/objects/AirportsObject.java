/**
 * 
 */
package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;

/**
 * @author matthi
 *
 */
public class AirportsObject {
	public static String CSV_HEADER_STRING = "\"id\",\"ident\",\"type\",\"name\",\"latitude_deg\",\"longitude_deg\",\"elevation_ft\",\"continent\",\"iso_country\",\"iso_region\",\"municipality\",\"scheduled_service\",\"gps_code\",\"iata_code\",\"local_code\",\"home_link\",\"wikipedia_link\",\"keywords\"";
	public static String[] CSV_HEADER_STRING_ARRAY = { "id", "ident", "type", "name", "latitude_deg", "longitude_deg",
			"elevation_ft", "continent", "iso_country", "iso_region", "municipality", "scheduled_service", "gps_code",
			"iata_code", "local_code", "home_link", "wikipedia_link", "keywords" };

	public static enum HEADER_FIELDS_ENUM {
		ID, IDENT, TYPE, NAME, LATITUDE_DEG, LONGITUDE_DEG, ELEVATION_FT, CONTINENT, ISO_COUNTRY, ISO_REGION,
		MUNICIPALITY, SCHEDULED_SERVICE, GPS_CODE, IATA_CODE, LOCAL_CODE, HOME_LINK, WIKIPEDIA_LINK, KEYWORDS
	};

	/**
	 * 
	 * @param fieldEnum
	 * @return
	 */
	public static Integer getColumnNumberFromFieldEnum(HEADER_FIELDS_ENUM fieldEnum) {
		switch (fieldEnum) {
		case ID:
			return 0;
		case IDENT:
			return 1;
		case TYPE:
			return 2;
		case NAME:
			return 3;
		case LATITUDE_DEG:
			return 4;
		case LONGITUDE_DEG:
			return 5;
		case ELEVATION_FT:
			return 6;
		case CONTINENT:
			return 7;
		case ISO_COUNTRY:
			return 8;
		case ISO_REGION:
			return 9;
		case MUNICIPALITY:
			return 10;
		case SCHEDULED_SERVICE:
			return 11;
		case GPS_CODE:
			return 12;
		case IATA_CODE:
			return 13;
		case LOCAL_CODE:
			return 14;
		case HOME_LINK:
			return 15;
		case WIKIPEDIA_LINK:
			return 16;
		case KEYWORDS:
			return 17;

		default:
			return null;
		}
	}

	public static int COLUMN_ID = 0;
	public static int COLUMN_IDENT = 1;
	public static int COLUMN_TYPE = 2;
	public static int COLUMN_NAME = 3;
	public static int COLUMN_LATITUDE_DEG = 4;
	public static int COLUMN_LONGITUDE_DEG = 5;
	public static int COLUMN_ELEVATION_FT = 6;
	public static int COLUMN_CONTINENT = 7;
	public static int COLUMN_ISO_COUNTRY = 8;
	public static int COLUMN_ISO_REGION = 9;
	public static int COLUMN_MUNICIPALITY = 10;
	public static int COLUMN_SCHEDULED_SERVICE = 11;
	public static int COLUMN_GPS_CODE = 12;
	public static int COLUMN_IATA_CODE = 13;
	public static int COLUMN_LOCAL_CODE = 14;
	public static int COLUMN_HOME_LINK = 15;
	public static int COLUMN_WIKIPEDIA_LINK = 16;
	public static int COLUMN_KEYWORDS = 17;
	@CsvBindByName
	private int id;
	@CsvBindByName
	private String ident;
	@CsvBindByName
	private String type;
	@CsvBindByName
	private String name;
	@CsvBindByName
	private String latitude_deg;
	@CsvBindByName
	private String longitude_deg;
	@CsvBindByName
	private int elevation_ft;
	@CsvBindByName
	private String continent;
	@CsvBindByName
	private String iso_country;
	@CsvBindByName
	private String iso_region;
	@CsvBindByName
	private String municipality;
	@CsvBindByName
	private Boolean scheduled_service;
	@CsvBindByName
	private String gps_code;
	@CsvBindByName
	private String iata_code;
	@CsvBindByName
	private String local_code;
	@CsvBindByName
	private String home_link;
	@CsvBindByName
	private String wikipedia_link;
	@CsvBindByName
	private String keywords;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}
	/**
	 * @param ident the ident to set
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the latitude_deg
	 */
	public String getLatitude_deg() {
		return latitude_deg;
	}
	/**
	 * @param latitude_deg the latitude_deg to set
	 */
	public void setLatitude_deg(String latitude_deg) {
		this.latitude_deg = latitude_deg;
	}
	/**
	 * @return the longitude_deg
	 */
	public String getLongitude_deg() {
		return longitude_deg;
	}
	/**
	 * @param longitude_deg the longitude_deg to set
	 */
	public void setLongitude_deg(String longitude_deg) {
		this.longitude_deg = longitude_deg;
	}
	/**
	 * @return the elevation_ft
	 */
	public int getElevation_ft() {
		return elevation_ft;
	}
	/**
	 * @param elevation_ft the elevation_ft to set
	 */
	public void setElevation_ft(int elevation_ft) {
		this.elevation_ft = elevation_ft;
	}
	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}
	/**
	 * @param continent the continent to set
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}
	/**
	 * @return the iso_country
	 */
	public String getIso_country() {
		return iso_country;
	}
	/**
	 * @param iso_country the iso_country to set
	 */
	public void setIso_country(String iso_country) {
		this.iso_country = iso_country;
	}
	/**
	 * @return the iso_region
	 */
	public String getIso_region() {
		return iso_region;
	}
	/**
	 * @param iso_region the iso_region to set
	 */
	public void setIso_region(String iso_region) {
		this.iso_region = iso_region;
	}
	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return municipality;
	}
	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * @return the scheduled_service
	 */
	public Boolean isScheduled_service() {
		return scheduled_service;
	}
	/**
	 * @param scheduled_service the scheduled_service to set
	 */
	public void setScheduled_service(Boolean scheduled_service) {
		this.scheduled_service = scheduled_service;
	}
	/**
	 * @return the gps_code
	 */
	public String getGps_code() {
		return gps_code;
	}
	/**
	 * @param gps_code the gps_code to set
	 */
	public void setGps_code(String gps_code) {
		this.gps_code = gps_code;
	}
	/**
	 * @return the iata_code
	 */
	public String getIata_code() {
		return iata_code;
	}
	/**
	 * @param iata_code the iata_code to set
	 */
	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}
	/**
	 * @return the local_code
	 */
	public String getLocal_code() {
		return local_code;
	}
	/**
	 * @param local_code the local_code to set
	 */
	public void setLocal_code(String local_code) {
		this.local_code = local_code;
	}
	/**
	 * @return the home_link
	 */
	public String getHome_link() {
		return home_link;
	}
	/**
	 * @param home_link the home_link to set
	 */
	public void setHome_link(String home_link) {
		this.home_link = home_link;
	}
	/**
	 * @return the wikipedia_link
	 */
	public String getWikipedia_link() {
		return wikipedia_link;
	}
	/**
	 * @param wikipedia_link the wikipedia_link to set
	 */
	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}
	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	

}
