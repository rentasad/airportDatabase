package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;

/**
 * 
 * @author matthi
 *
 */
public class AirportFrequenciesObjects {

	@CsvBindByName
	private int id;

	@CsvBindByName
	private int airport_ref;

	@CsvBindByName
	private String airport_ident;

	@CsvBindByName
	private String type;

	@CsvBindByName
	private String description;

	@CsvBindByName
	private String frequency_mhz;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the frequency_mhz
	 */
	public String getFrequency_mhz() {
		return frequency_mhz;
	}

	/**
	 * @param frequency_mhz the frequency_mhz to set
	 */
	public void setFrequency_mhz(String frequency_mhz) {
		this.frequency_mhz = frequency_mhz;
	}

}
