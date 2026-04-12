package rentasad.tools.airportsDatabase.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class AirportFrequency {

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
}
