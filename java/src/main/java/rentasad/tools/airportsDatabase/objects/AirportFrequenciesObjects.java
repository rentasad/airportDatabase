package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 * 
 * @author matthi
 *
 */
@Data
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

}
