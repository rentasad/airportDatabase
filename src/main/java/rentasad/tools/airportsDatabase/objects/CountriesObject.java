package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;

public class CountriesObject {
	
	@CsvBindByName
	private int id;
	
	@CsvBindByName
	private String code;
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private String continent;
	
	@CsvBindByName
	private String wikipedia_link;

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
	private String keywords;

}
