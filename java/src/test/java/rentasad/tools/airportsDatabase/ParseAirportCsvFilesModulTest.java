package rentasad.tools.airportsDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import rentasad.tools.airportsDatabase.objects.AirportFrequenciesObjects;
import rentasad.tools.airportsDatabase.objects.AirportsObject;
import rentasad.tools.airportsDatabase.objects.CountriesObject;
import rentasad.tools.airportsDatabase.objects.NavaidsObject;
import rentasad.tools.airportsDatabase.objects.RegionsObject;

public class ParseAirportCsvFilesModulTest {

	@BeforeAll
	public static void init() throws Exception {

	}

	@Test
	public void testParseAirportCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFileUrl = classLoader.getResource("test/airports.csv");
		List<AirportsObject> airportList = ParseAirportCsvFilesModul.parseAirportCsv(airportFileUrl.getFile());
		AirportsObject ao = airportList.get(0);
		assertEquals(ao.getContinent(), "EU");
		assertEquals(ao.getElevation_ft(), 465);
		assertEquals(ao.getGps_code(), "EDDP");
		assertEquals(ao.getHome_link(), "http://www.leipzig-halle-airport.de/en/index.html");
		assertEquals(ao.getIata_code(), "LEJ");
		assertEquals(ao.getId(), 2220);
		assertEquals(ao.getIdent(), "EDDP");
		assertEquals(ao.getIso_country(), "DE");
		assertEquals(ao.getIso_region(), "DE-SN");
		assertEquals(ao.getKeywords(), "Schkeuditz Airport");
		assertEquals(ao.getLatitude_deg(), "51.423889");
		assertEquals(ao.getLocal_code(), "");
		assertEquals(ao.getLongitude_deg(), "12.236389");
		assertEquals(ao.getMunicipality(), "Leipzig");
		assertEquals(ao.getName(), "Leipzig/Halle Airport");
		assertEquals(ao.getType(), "large_airport");
		assertTrue(ao.isScheduled_service());
		assertEquals(ao.getWikipedia_link(), "https://en.wikipedia.org/wiki/Leipzig/Halle_Airport");
	}

	@Test
	public void testParseAirportFrequenciesCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFrequenciesFileUrl = classLoader.getResource("test/airport-frequencies.csv");
		List<AirportFrequenciesObjects> airportFrequenciesList = ParseAirportCsvFilesModul
				.parseAirportFrequenciesCsv(airportFrequenciesFileUrl.getFile());
		assertTrue(airportFrequenciesList.size() == 1);
		AirportFrequenciesObjects af = airportFrequenciesList.get(0);
		assertEquals(af.getId(), 52814);
		assertEquals(af.getAirport_ref(), 2220);
		assertEquals(af.getAirport_ident(), "EDDP");
		assertEquals(af.getType(), "APP");
		assertEquals(af.getDescription(), "MUNCHEN RADAR");
		assertEquals(af.getFrequency_mhz(), "124.175");

	}

	@Test
	public void testParseRunwayCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFrequenciesFileUrl = classLoader.getResource("test/regions.csv");
		List<RegionsObject> regionsList = ParseAirportCsvFilesModul
				.parseRegionsCsv(airportFrequenciesFileUrl.getFile());
		assertTrue(regionsList.size() == 1);
		RegionsObject ro = regionsList.get(0);
		assertEquals(ro.getId(), 303548);
		assertEquals(ro.getCode(), "DE-BE");
		assertEquals(ro.getLocal_code(), "BE");
		assertEquals(ro.getName(), "Berlin");
		assertEquals(ro.getContinent(), "EU");
		assertEquals(ro.getIso_country(), "DE");
		assertEquals(ro.getWikipedia_link(), "https://en.wikipedia.org/wiki/Berlin");
		assertEquals(ro.getKeywords(), "");

	}

	@Test
	public void testParseCountriesCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL countriesFileUrl = classLoader.getResource("test/countries.csv");
		List<CountriesObject> countriesList = ParseAirportCsvFilesModul.parseCountriesCsv(countriesFileUrl.getFile());
		CountriesObject co = countriesList.get(0);
		assertEquals(co.getId(), 302681);
		assertEquals(co.getCode(), "DE");
		assertEquals(co.getName(), "Germany");
		assertEquals(co.getContinent(), "EU");
		assertEquals(co.getWikipedia_link(), "https://en.wikipedia.org/wiki/Germany");
		assertEquals(co.getKeywords(), "Flughäfen in Deutschland");
	}

	@Test
	public void testParseNavaidsCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL navAidsFileUrl = classLoader.getResource("test/navaids.csv");
		List<NavaidsObject> navaidsList = ParseAirportCsvFilesModul.parseNavaidsCsv(navAidsFileUrl.getFile());
		NavaidsObject no = navaidsList.get(0);
		assertEquals(no.getAssociated_airport(), "EDDP");
		assertEquals(no.getDme_channel(), "058Y");
		assertEquals(no.getDme_elevation_ft(), 0);
		assertEquals(no.getDme_frequency_khz(), 112150);
		assertEquals(no.getDme_latitude_deg(), "");
		assertEquals(no.getDme_longitude_deg(), "");
		assertEquals(no.getElevation_ft(), 502);
		assertEquals(no.getFilename(), "Leipzig_South_DME_DE");
		assertEquals(no.getFrequency_khz(), 112150);
		assertEquals(no.getId(), 90270);
		assertEquals(no.getIdent(), "LED");
		assertEquals(no.getIso_country(), "DE");
		assertEquals(no.getLatitude_deg(), "51.41130065917969");
		assertEquals(no.getLongitude_deg(), "12.223799705505371");
		assertEquals(no.getMagnetic_variation_deg(), "1.493");
		assertEquals(no.getName(), "Leipzig South");
		assertEquals(no.getPower(), "LOW");
		assertEquals(no.getSlaved_variation_deg(), "");
		assertEquals(no.getType(), "DME");
		assertEquals(no.getUsageType(), "TERMINAL");

	}

}
