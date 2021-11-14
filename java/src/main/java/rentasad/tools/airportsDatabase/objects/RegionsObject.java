package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;
/**
 * 
 * @author matthi
 *
 */
public class RegionsObject {

	@CsvBindByName
	private int id;
	
	@CsvBindByName
	private String code;
	
	@CsvBindByName
	private String local_code;
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private String continent;
	
	@CsvBindByName
	private String iso_country;
	
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
