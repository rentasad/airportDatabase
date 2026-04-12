package rentasad.tools.airportsDatabase;

import lombok.extern.java.Log;
import rentasad.library.basicTools.DownloadAirportFilesModul;
import rentasad.tools.airportsDatabase.model.*;

import java.util.List;

/**
 * Service class responsible for importing airport-related data into a database.
 * This class handles the process of downloading, parsing, and inserting data
 * for various entities such as airports, frequencies, countries, navaids, regions,
 * and runways into the database.
 */
@Log
public class AirportImportService {

    private final AirportDatabaseTool dbTool;

    public AirportImportService(AirportDatabaseTool dbTool) {
        this.dbTool = dbTool;
    }

    public void importData() throws Exception {
        log.info("Starting airport data import process...");

        DownloadAirportFilesModul.airportFileDownloader();

        log.info("Parsing CSV files...");
        List<AirportsObject> airports = ParseAirportCsvFilesModul.parseAirportCsv("resources/download/airports.csv");
        List<AirportFrequenciesObject> frequencies = ParseAirportCsvFilesModul.parseAirportFrequenciesCsv("resources/download/airport-frequencies.csv");
        List<CountriesObject> countries = ParseAirportCsvFilesModul.parseCountriesCsv("resources/download/countries.csv");
        List<NavaidsObject> navaids = ParseAirportCsvFilesModul.parseNavaidsCsv("resources/download/navaids.csv");
        List<RegionsObject> regions = ParseAirportCsvFilesModul.parseRegionsCsv("resources/download/regions.csv");
        List<RunwaysObject> runways = ParseAirportCsvFilesModul.parseRunwayCsv("resources/download/runways.csv");

        log.info("Creating database structure...");
        dbTool.createDatabase();

        log.info("Inserting data into database...");
        dbTool.addAirports(airports);
        dbTool.addAirportFrequencies(frequencies);
        dbTool.addCountries(countries);
        dbTool.addRunways(runways);
        dbTool.addRegions(regions);
        dbTool.addNavaids(navaids);

        log.info("Import process finished successfully.");
    }
}
