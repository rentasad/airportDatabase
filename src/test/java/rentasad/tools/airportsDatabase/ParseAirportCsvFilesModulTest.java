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

import rentasad.tools.airportsDatabase.model.AirportFrequenciesObject;
import rentasad.tools.airportsDatabase.model.AirportsObject;
import rentasad.tools.airportsDatabase.model.CountriesObject;
import rentasad.tools.airportsDatabase.model.NavaidsObject;
import rentasad.tools.airportsDatabase.model.RegionsObject;

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
		assertEquals("EU", ao.getContinent());
		assertEquals(465, ao.getElevation_ft());
		assertEquals("EDDP", ao.getGps_code());
		assertEquals("http://www.leipzig-halle-airport.de/en/index.html", ao.getHome_link());
		assertEquals("LEJ", ao.getIata_code());
		assertEquals(2220, ao.getId());
		assertEquals("EDDP", ao.getIdent());
		assertEquals("DE", ao.getIso_country());
		assertEquals("DE-SN", ao.getIso_region());
		assertEquals("Schkeuditz Airport", ao.getKeywords());
		assertEquals("51.423889", ao.getLatitude_deg());
		assertEquals("", ao.getLocal_code());
		assertEquals("12.236389", ao.getLongitude_deg());
		assertEquals("Leipzig", ao.getMunicipality());
		assertEquals("Leipzig/Halle Airport", ao.getName());
		assertEquals("large_airport", ao.getType());
		assertTrue(ao.getScheduled_service());
		assertEquals("https://en.wikipedia.org/wiki/Leipzig/Halle_Airport", ao.getWikipedia_link());
	}

	@Test
	public void testParseAirportFrequenciesCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFrequenciesFileUrl = classLoader.getResource("test/airport-frequencies.csv");
		List<AirportFrequenciesObject> airportFrequenciesList = ParseAirportCsvFilesModul
				.parseAirportFrequenciesCsv(airportFrequenciesFileUrl.getFile());
        assertEquals(1, airportFrequenciesList.size());
		AirportFrequenciesObject af = airportFrequenciesList.get(0);
		assertEquals(52814, af.getId());
		assertEquals(2220, af.getAirport_ref());
		assertEquals("EDDP", af.getAirport_ident());
		assertEquals("APP", af.getType());
		assertEquals("MUNCHEN RADAR", af.getDescription());
		assertEquals("124.175", af.getFrequency_mhz());

	}

	@Test
	public void testParseRunwayCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFrequenciesFileUrl = classLoader.getResource("test/regions.csv");
		List<RegionsObject> regionsList = ParseAirportCsvFilesModul
				.parseRegionsCsv(airportFrequenciesFileUrl.getFile());
		assertTrue(regionsList.size() == 1);
		RegionsObject ro = regionsList.get(0);
		assertEquals(303548, ro.getId());
		assertEquals("DE-BE", ro.getCode());
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
