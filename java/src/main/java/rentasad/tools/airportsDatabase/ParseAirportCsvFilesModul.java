/**
 * 
 */
package rentasad.tools.airportsDatabase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import rentasad.tools.airportsDatabase.objects.AirportFrequenciesObjects;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
import rentasad.tools.airportsDatabase.objects.CountriesObject;
import rentasad.tools.airportsDatabase.objects.NavaidsObject;
import rentasad.tools.airportsDatabase.objects.RegionsObject;
import rentasad.tools.airportsDatabase.objects.RunwaysObject;

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
	public List<AirportsObject> parseAirportCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<AirportsObject> beanReader = new CsvToBeanBuilder<AirportsObject>(reader)
				.withType(AirportsObject.class).withSeparator(',').withQuoteChar('"').build();
		List<AirportsObject> airportList = beanReader.parse();
		return airportList;
	}
	
	/**
	 * 
	 * @param csvFilePath
	 * @return
	 * @throws IOException
	 * @throws CsvException
	 * @throws URISyntaxException
	 */
	public List<AirportFrequenciesObjects> parseAirportFrequenciesCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<AirportFrequenciesObjects> beanReader = new CsvToBeanBuilder<AirportFrequenciesObjects>(reader)
				.withType(AirportFrequenciesObjects.class).withSeparator(',').withQuoteChar('"').build();
		List<AirportFrequenciesObjects> airportFrequenciesObjectsList = beanReader.parse();
		return airportFrequenciesObjectsList;
		
	}
	/**
	 * 
	 * @param csvFilePath
	 * @return
	 * @throws IOException
	 * @throws CsvException
	 * @throws URISyntaxException
	 */
	public List<CountriesObject> parseCountriesCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<CountriesObject> beanReader = new CsvToBeanBuilder<CountriesObject>(reader)
				.withType(CountriesObject.class).withSeparator(',').withQuoteChar('"').build();
		List<CountriesObject> countriesList = beanReader.parse();
		return countriesList;
		
	}
	
	/**
	 * 
	 * @param csvFilePath
	 * @return
	 * @throws IOException
	 * @throws CsvException
	 * @throws URISyntaxException
	 */
	public List<NavaidsObject> parseNavaidsCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<NavaidsObject> beanReader = new CsvToBeanBuilder<NavaidsObject>(reader)
				.withType(NavaidsObject.class).withSeparator(',').withQuoteChar('"').build();
		List<NavaidsObject> navaidsObjectList = beanReader.parse();
		return navaidsObjectList;
		
	}
	
	/**
	 * 
	 * @param csvFilePath
	 * @return
	 * @throws IOException
	 * @throws CsvException
	 * @throws URISyntaxException
	 */
	public List<RegionsObject> parseRegionsCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<RegionsObject> beanReader = new CsvToBeanBuilder<RegionsObject>(reader)
				.withType(RegionsObject.class).withSeparator(',').withQuoteChar('"').build();
		List<RegionsObject> regionsObjectList = beanReader.parse();
		return regionsObjectList;
		
	}
	
	/**
	 * 
	 * @param csvFilePath
	 * @return
	 * @throws IOException
	 * @throws CsvException
	 * @throws URISyntaxException
	 */
	public List<RunwaysObject> parseRunwayCsv(final String csvFilePath)
			throws IOException, CsvException, URISyntaxException {

		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		CsvToBean<RunwaysObject> beanReader = new CsvToBeanBuilder<RunwaysObject>(reader)
				.withType(RunwaysObject.class).withSeparator(',').withQuoteChar('"').build();
		List<RunwaysObject> regionsObjectList = beanReader.parse();
		return regionsObjectList;
		
	}
}
