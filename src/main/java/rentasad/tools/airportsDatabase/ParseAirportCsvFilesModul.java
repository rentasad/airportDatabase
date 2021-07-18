/**
 * 
 */
package rentasad.tools.airportsDatabase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import rentasad.tools.airportsDatabase.objects.AirportsObject;

/**
 * @author matthi
 *
 */
public class ParseAirportCsvFilesModul {
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws CsvException
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public List<AirportsObject> parseAirportCsv(final String csvFilePath) throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<AirportsObject> beanReader= new CsvToBeanBuilder<AirportsObject>(reader)
			       .withType(AirportsObject.class).withSeparator(',').withQuoteChar('"').build();
		List<AirportsObject> airportList  =beanReader.parse();
		return airportList;
	}

}
