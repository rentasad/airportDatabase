package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;

public class NavaidsObject {
	
	@CsvBindByName
	private Integer id;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@CsvBindByName
	private String filename;
	
	@CsvBindByName
	private String ident;
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private String type;
	
	@CsvBindByName
	private int frequency_khz;
	
	@CsvBindByName
	private String latitude_deg;
	
	@CsvBindByName
	private String longitude_deg;
	
	@CsvBindByName
	private int elevation_ft;
	
	@CsvBindByName
	private String iso_country;
	
	@CsvBindByName
	private int dme_frequency_khz;
	
	@CsvBindByName
	private String dme_channel;
	
	@CsvBindByName
	private String dme_latitude_deg;
	
	@CsvBindByName
	private String dme_longitude_deg;
	
	@CsvBindByName
	private int dme_elevation_ft;
	
	@CsvBindByName
	private String slaved_variation_deg;
	
	@CsvBindByName
	private String magnetic_variation_deg;
	
	@CsvBindByName
	private String usageType;
	
	@CsvBindByName
	private String power;
	
	@CsvBindByName
	private String associated_airport;

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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
	 * @return the frequency_khz
	 */
	public int getFrequency_khz() {
		return frequency_khz;
	}

	/**
	 * @param frequency_khz the frequency_khz to set
	 */
	public void setFrequency_khz(int frequency_khz) {
		this.frequency_khz = frequency_khz;
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
	 * @return the dme_frequency_khz
	 */
	public int getDme_frequency_khz() {
		return dme_frequency_khz;
	}

	/**
	 * @param dme_frequency_khz the dme_frequency_khz to set
	 */
	public void setDme_frequency_khz(int dme_frequency_khz) {
		this.dme_frequency_khz = dme_frequency_khz;
	}

	/**
	 * @return the dme_channel
	 */
	public String getDme_channel() {
		return dme_channel;
	}

	/**
	 * @param dme_channel the dme_channel to set
	 */
	public void setDme_channel(String dme_channel) {
		this.dme_channel = dme_channel;
	}

	/**
	 * @return the dme_latitude_deg
	 */
	public String getDme_latitude_deg() {
		return dme_latitude_deg;
	}

	/**
	 * @param dme_latitude_deg the dme_latitude_deg to set
	 */
	public void setDme_latitude_deg(String dme_latitude_deg) {
		this.dme_latitude_deg = dme_latitude_deg;
	}

	/**
	 * @return the dme_longitude_deg
	 */
	public String getDme_longitude_deg() {
		return dme_longitude_deg;
	}

	/**
	 * @param dme_longitude_deg the dme_longitude_deg to set
	 */
	public void setDme_longitude_deg(String dme_longitude_deg) {
		this.dme_longitude_deg = dme_longitude_deg;
	}

	/**
	 * @return the dme_elevation_ft
	 */
	public int getDme_elevation_ft() {
		return dme_elevation_ft;
	}

	/**
	 * @param dme_elevation_ft the dme_elevation_ft to set
	 */
	public void setDme_elevation_ft(int dme_elevation_ft) {
		this.dme_elevation_ft = dme_elevation_ft;
	}

	




	/**
	 * @return the slaved_variation_deg
	 */
	public String getSlaved_variation_deg() {
		return slaved_variation_deg;
	}

	/**
	 * @param slaved_variation_deg the slaved_variation_deg to set
	 */
	public void setSlaved_variation_deg(String slaved_variation_deg) {
		this.slaved_variation_deg = slaved_variation_deg;
	}

	/**
	 * @return the magnetic_variation_deg
	 */
	public String getMagnetic_variation_deg() {
		return magnetic_variation_deg;
	}

	/**
	 * @param magnetic_variation_deg the magnetic_variation_deg to set
	 */
	public void setMagnetic_variation_deg(String magnetic_variation_deg) {
		this.magnetic_variation_deg = magnetic_variation_deg;
	}

	/**
	 * @return the usageType
	 */
	public String getUsageType() {
		return usageType;
	}

	/**
	 * @param usageType the usageType to set
	 */
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}

	/**
	 * @return the associated_airport
	 */
	public String getAssociated_airport() {
		return associated_airport;
	}

	/**
	 * @param associated_airport the associated_airport to set
	 */
	public void setAssociated_airport(String associated_airport) {
		this.associated_airport = associated_airport;
	}

}
