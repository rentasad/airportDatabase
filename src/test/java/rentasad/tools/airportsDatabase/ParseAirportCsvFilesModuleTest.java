package rentasad.tools.airportsDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

import rentasad.tools.airportsDatabase.model.AirportFrequency;
import rentasad.tools.airportsDatabase.model.Airport;
import rentasad.tools.airportsDatabase.model.Country;
import rentasad.tools.airportsDatabase.model.Navaid;
import rentasad.tools.airportsDatabase.model.Region;

public class ParseAirportCsvFilesModuleTest {

	@Test
	public void testParseAirportCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL airportFileUrl = classLoader.getResource("test/airports.csv");
		List<Airport> airportList = ParseAirportCsvFilesModule.parseCsv(airportFileUrl.getFile(), Airport.class);
		Airport ao = airportList.get(0);
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
		List<AirportFrequency> airportFrequenciesList = ParseAirportCsvFilesModule
				.parseCsv(airportFrequenciesFileUrl.getFile(), AirportFrequency.class);
		assertEquals(1, airportFrequenciesList.size());
		AirportFrequency af = airportFrequenciesList.get(0);
		assertEquals(52814, af.getId());
		assertEquals(2220, af.getAirport_ref());
		assertEquals("EDDP", af.getAirport_ident());
		assertEquals("APP", af.getType());
		assertEquals("MUNCHEN RADAR", af.getDescription());
		assertEquals("124.175", af.getFrequency_mhz());
	}

	@Test
	public void testParseRegionsCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL regionsFileUrl = classLoader.getResource("test/regions.csv");
		List<Region> regionsList = ParseAirportCsvFilesModule.parseCsv(regionsFileUrl.getFile(), Region.class);
		assertTrue(regionsList.size() == 1);
		Region ro = regionsList.get(0);
		assertEquals(303548, ro.getId());
		assertEquals("DE-BE", ro.getCode());
		assertEquals("BE", ro.getLocal_code());
		assertEquals("Berlin", ro.getName());
		assertEquals("EU", ro.getContinent());
		assertEquals("DE", ro.getIso_country());
		assertEquals("https://en.wikipedia.org/wiki/Berlin", ro.getWikipedia_link());
		assertEquals("", ro.getKeywords());
	}

	@Test
	public void testParseCountriesCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL countriesFileUrl = classLoader.getResource("test/countries.csv");
		List<Country> countriesList = ParseAirportCsvFilesModule.parseCsv(countriesFileUrl.getFile(), Country.class);
		Country co = countriesList.get(0);
		assertEquals(302681, co.getId());
		assertEquals("DE", co.getCode());
		assertEquals("Germany", co.getName());
		assertEquals("EU", co.getContinent());
		assertEquals("https://en.wikipedia.org/wiki/Germany", co.getWikipedia_link());
		assertEquals("Flughäfen in Deutschland", co.getKeywords());
	}

	@Test
	public void testParseNavaidsCsv() throws IOException, CsvException, URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL navAidsFileUrl = classLoader.getResource("test/navaids.csv");
		List<Navaid> navaidsList = ParseAirportCsvFilesModule.parseCsv(navAidsFileUrl.getFile(), Navaid.class);
		Navaid no = navaidsList.get(0);
		assertEquals("EDDP", no.getAssociated_airport());
		assertEquals("058Y", no.getDme_channel());
		assertEquals(0, no.getDme_elevation_ft());
		assertEquals(112150, no.getDme_frequency_khz());
		assertEquals("", no.getDme_latitude_deg());
		assertEquals("", no.getDme_longitude_deg());
		assertEquals(502, no.getElevation_ft());
		assertEquals("Leipzig_South_DME_DE", no.getFilename());
		assertEquals(112150, no.getFrequency_khz());
		assertEquals(90270, no.getId());
		assertEquals("LED", no.getIdent());
		assertEquals("DE", no.getIso_country());
		assertEquals("51.41130065917969", no.getLatitude_deg());
		assertEquals("12.223799705505371", no.getLongitude_deg());
		assertEquals("1.493", no.getMagnetic_variation_deg());
		assertEquals("Leipzig South", no.getName());
		assertEquals("LOW", no.getPower());
		assertEquals("", no.getSlaved_variation_deg());
		assertEquals("DME", no.getType());
		assertEquals("TERMINAL", no.getUsageType());
	}
}
