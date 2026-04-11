/**
 * 
 */
package rentasad.tools.airportsDatabase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import lombok.extern.java.Log;
import rentasad.tools.airportsDatabase.objects.AirportFrequenciesObjects;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
import rentasad.tools.airportsDatabase.objects.CountriesObject;
import rentasad.tools.airportsDatabase.objects.NavaidsObject;
import rentasad.tools.airportsDatabase.objects.RegionsObject;
import rentasad.tools.airportsDatabase.objects.RunwaysObject;

/**
 * The ParseAirportCsvFilesModul class provides utility methods to parse various types
 * of CSV files related to aviation data, including information about airports,
 * airport frequencies, countries, navaids, regions, and runways. Each CSV file is
 * mapped to a list of corresponding data objects by leveraging the OpenCSV library.
 */
@Log
public class ParseAirportCsvFilesModul {

	/**
	 * Generic method to parse a CSV file into a list of beans.
	 *
	 * @param filePath the file path of the CSV file to be parsed
	 * @param clazz    the class of the bean to which the CSV data will be mapped
	 * @param <T>      the type of the bean
	 * @return a list of beans containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static <T> List<T> parseCsv(String filePath, Class<T> clazz) throws IOException {
		log.info(String.format("Parsing CSV file: %s", filePath));
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			return new CsvToBeanBuilder<T>(reader)
					.withType(clazz)
					.withSeparator(',')
					.withQuoteChar('"')
					.build()
					.parse();
		}
	}

	/**
	 * Parses a CSV file containing airport data and converts it into a list of AirportsObject.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of AirportsObject containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<AirportsObject> parseAirportCsv(final String csvFilePath) throws IOException {
		return parseCsv(csvFilePath, AirportsObject.class);
	}

	/**
	 * Parses a CSV file containing airport frequency data and converts it into a list of
	 * AirportFrequenciesObjects.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of AirportFrequenciesObjects containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<AirportFrequenciesObjects> parseAirportFrequenciesCsv(final String csvFilePath)
			throws IOException {
		return parseCsv(csvFilePath, AirportFrequenciesObjects.class);
	}

	/**
	 * Parses a CSV file containing country data and converts it into a list of CountriesObject.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of CountriesObject containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<CountriesObject> parseCountriesCsv(final String csvFilePath) throws IOException {
		return parseCsv(csvFilePath, CountriesObject.class);
	}

	/**
	 * Parses a CSV file containing navaid data and converts it into a list of NavaidsObject.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of NavaidsObject containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<NavaidsObject> parseNavaidsCsv(final String csvFilePath) throws IOException {
		return parseCsv(csvFilePath, NavaidsObject.class);
	}

	/**
	 * Parses a CSV file containing region data and converts it into a list of RegionsObject.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of RegionsObject containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<RegionsObject> parseRegionsCsv(final String csvFilePath) throws IOException {
		return parseCsv(csvFilePath, RegionsObject.class);
	}

	/**
	 * Parses a CSV file containing runway data and converts it into a list of RunwaysObject.
	 *
	 * @param csvFilePath the file path of the CSV file to be parsed
	 * @return a list of RunwaysObject containing the data from the CSV file
	 * @throws IOException if an I/O error occurs while reading the file
	 */
	public static List<RunwaysObject> parseRunwayCsv(final String csvFilePath) throws IOException {
		return parseCsv(csvFilePath, RunwaysObject.class);
	}
}
