package rentasad.tools.airportsDatabase.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Navaid {

	@CsvBindByName
	private Integer id;
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
}
