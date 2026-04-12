package rentasad.tools.airportsDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.extern.java.Log;
import rentasad.tools.airportsDatabase.model.AirportFrequency;
import rentasad.tools.airportsDatabase.model.Airport;
import rentasad.tools.airportsDatabase.model.Country;
import rentasad.tools.airportsDatabase.model.Navaid;
import rentasad.tools.airportsDatabase.model.Region;
import rentasad.tools.airportsDatabase.model.Runway;

/**
 * Utility class providing methods to parse CSV files containing aviation data
 * (airports, frequencies, countries, navaids, regions, runways) into Java objects.
 */
@Log
public class ParseAirportCsvFilesModule {

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
		try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
			return new CsvToBeanBuilder<T>(reader)
					.withType(clazz)
					.withSeparator(',')
					.withQuoteChar('"')
					.build()
					.parse();
		}
	}
}
