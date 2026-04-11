package rentasad.tools.airportsDatabase.objects;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 * The RegionsObject class represents a data model for regional information
 * with fields mapped from a CSV file using the OpenCSV library.
 *
 * Each field in the class corresponds to a column in the CSV file and is annotated
 * with @CsvBindByName for automatic binding and parsing.
 *
 * This class is typically used to store and process information related to regions,
 * such as their identifiers, codes, names, and related metadata.
 */
@Data
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


}
