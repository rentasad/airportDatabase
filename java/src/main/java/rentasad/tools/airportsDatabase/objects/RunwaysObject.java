package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;

/**
 * 
 * @author matthi
 *
 */
public class RunwaysObject {

	@CsvBindByName
	private int id;
	
	@CsvBindByName
	private int airport_ref;
	
	@CsvBindByName
	private String airport_ident;
	
	@CsvBindByName
	private int length_ft;
	
	@CsvBindByName
	private int width_ft;
	
	@CsvBindByName
	private String surface;
	
	@CsvBindByName
	private boolean lighted;
	
	@CsvBindByName
	private boolean closed;
	
	@CsvBindByName
	private String le_ident;
	
	@CsvBindByName
	private String le_latitude_deg;
	
	@CsvBindByName
	private String le_longitude_deg;
	
	@CsvBindByName
	private int le_elevation_ft;
	
	@CsvBindByName
	private String le_heading_degT;
	
	@CsvBindByName
	private int le_displaced_threshold_ft;
	
	@CsvBindByName
	private String he_ident;
	
	@CsvBindByName
	private String he_latitude_deg;
	
	@CsvBindByName
	private String he_longitude_deg;
	
	@CsvBindByName
	private int he_elevation_ft;
	
	@CsvBindByName
	private String he_heading_degT;
	
	@CsvBindByName
	private int he_displaced_threshold_ft;

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
	 * @return the airport_ref
	 */
	public int getAirport_ref() {
		return airport_ref;
	}

	/**
	 * @param airport_ref the airport_ref to set
	 */
	public void setAirport_ref(int airport_ref) {
		this.airport_ref = airport_ref;
	}

	/**
	 * @return the airport_ident
	 */
	public String getAirport_ident() {
		return airport_ident;
	}

	/**
	 * @param airport_ident the airport_ident to set
	 */
	public void setAirport_ident(String airport_ident) {
		this.airport_ident = airport_ident;
	}

	/**
	 * @return the length_ft
	 */
	public int getLength_ft() {
		return length_ft;
	}

	/**
	 * @param length_ft the length_ft to set
	 */
	public void setLength_ft(int length_ft) {
		this.length_ft = length_ft;
	}

	/**
	 * @return the width_ft
	 */
	public int getWidth_ft() {
		return width_ft;
	}

	/**
	 * @param width_ft the width_ft to set
	 */
	public void setWidth_ft(int width_ft) {
		this.width_ft = width_ft;
	}

	/**
	 * @return the surface
	 */
	public String getSurface() {
		return surface;
	}

	/**
	 * @param surface the surface to set
	 */
	public void setSurface(String surface) {
		this.surface = surface;
	}

	/**
	 * @return the lighted
	 */
	public boolean isLighted() {
		return lighted;
	}

	/**
	 * @param lighted the lighted to set
	 */
	public void setLighted(boolean lighted) {
		this.lighted = lighted;
	}

	/**
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * @param closed the closed to set
	 */
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	/**
	 * @return the le_ident
	 */
	public String getLe_ident() {
		return le_ident;
	}

	/**
	 * @param le_ident the le_ident to set
	 */
	public void setLe_ident(String le_ident) {
		this.le_ident = le_ident;
	}

	/**
	 * @return the le_latitude_deg
	 */
	public String getLe_latitude_deg() {
		return le_latitude_deg;
	}

	/**
	 * @param le_latitude_deg the le_latitude_deg to set
	 */
	public void setLe_latitude_deg(String le_latitude_deg) {
		this.le_latitude_deg = le_latitude_deg;
	}

	/**
	 * @return the le_longitude_deg
	 */
	public String getLe_longitude_deg() {
		return le_longitude_deg;
	}

	/**
	 * @param le_longitude_deg the le_longitude_deg to set
	 */
	public void setLe_longitude_deg(String le_longitude_deg) {
		this.le_longitude_deg = le_longitude_deg;
	}

	/**
	 * @return the le_elevation_ft
	 */
	public int getLe_elevation_ft() {
		return le_elevation_ft;
	}

	/**
	 * @param le_elevation_ft the le_elevation_ft to set
	 */
	public void setLe_elevation_ft(int le_elevation_ft) {
		this.le_elevation_ft = le_elevation_ft;
	}




	/**
	 * @return the le_heading_degT
	 */
	public String getLe_heading_degT() {
		return le_heading_degT;
	}

	/**
	 * @param le_heading_degT the le_heading_degT to set
	 */
	public void setLe_heading_degT(String le_heading_degT) {
		this.le_heading_degT = le_heading_degT;
	}

	/**
	 * @return the he_heading_degT
	 */
	public String getHe_heading_degT() {
		return he_heading_degT;
	}

	/**
	 * @param he_heading_degT the he_heading_degT to set
	 */
	public void setHe_heading_degT(String he_heading_degT) {
		this.he_heading_degT = he_heading_degT;
	}

	/**
	 * @return the le_displaced_threshold_ft
	 */
	public int getLe_displaced_threshold_ft() {
		return le_displaced_threshold_ft;
	}

	/**
	 * @param le_displaced_threshold_ft the le_displaced_threshold_ft to set
	 */
	public void setLe_displaced_threshold_ft(int le_displaced_threshold_ft) {
		this.le_displaced_threshold_ft = le_displaced_threshold_ft;
	}

	/**
	 * @return the he_ident
	 */
	public String getHe_ident() {
		return he_ident;
	}

	/**
	 * @param he_ident the he_ident to set
	 */
	public void setHe_ident(String he_ident) {
		this.he_ident = he_ident;
	}

	/**
	 * @return the he_latitude_deg
	 */
	public String getHe_latitude_deg() {
		return he_latitude_deg;
	}

	/**
	 * @param he_latitude_deg the he_latitude_deg to set
	 */
	public void setHe_latitude_deg(String he_latitude_deg) {
		this.he_latitude_deg = he_latitude_deg;
	}

	/**
	 * @return the he_longitude_deg
	 */
	public String getHe_longitude_deg() {
		return he_longitude_deg;
	}

	/**
	 * @param he_longitude_deg the he_longitude_deg to set
	 */
	public void setHe_longitude_deg(String he_longitude_deg) {
		this.he_longitude_deg = he_longitude_deg;
	}

	/**
	 * @return the he_elevation_ft
	 */
	public int getHe_elevation_ft() {
		return he_elevation_ft;
	}

	/**
	 * @param he_elevation_ft the he_elevation_ft to set
	 */
	public void setHe_elevation_ft(int he_elevation_ft) {
		this.he_elevation_ft = he_elevation_ft;
	}


	/**
	 * @return the he_displaced_threshold_ft
	 */
	public int getHe_displaced_threshold_ft() {
		return he_displaced_threshold_ft;
	}

	/**
	 * @param he_displaced_threshold_ft the he_displaced_threshold_ft to set
	 */
	public void setHe_displaced_threshold_ft(int he_displaced_threshold_ft) {
		this.he_displaced_threshold_ft = he_displaced_threshold_ft;
	}

	
}
