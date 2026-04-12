package rentasad.tools.airportsDatabase.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 * 
 * @author matthi
 *
 */
@Data
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

	
}
