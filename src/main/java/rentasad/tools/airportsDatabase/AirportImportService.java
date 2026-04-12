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

    /**
     * Constructs an instance of the AirportImportService.
     * This service is responsible for importing airport-related data into a database.
     *
     * @param dbTool an instance of {@code AirportDatabaseTool} used to interact with
     *               the database for creating structures and inserting data.
     */
    public AirportImportService(AirportDatabaseTool dbTool) {
        this.dbTool = dbTool;
    }

    /**
     * Imports airport-related data into the database.
     *
     * This method performs the following steps:
     * 1. Logs the start of the import process.
     * 2. Downloads required CSV files containing data for airports, frequencies, countries, navaids,
     *    regions, and runways using the {@code DownloadAirportFilesModul.airportFileDownloader()} method.
     * 3. Parses the downloaded CSV files into corresponding Java objects using methods from
     *    {@code ParseAirportCsvFilesModul}.
     * 4. Creates the necessary database structure using the {@code dbTool.createDatabase()} method.
     * 5. Inserts the parsed data into the database using appropriate methods in the {@code dbTool} object.
     * 6. Logs the successful completion of the import process.
     *
     * @throws Exception if an error occurs during any stage of the import process. Possible reasons include:
     *                    - Failure to download CSV files.
     *                    - Issues with parsing the CSV files.
     *                    - Errors related to creating the database or inserting data into it.
     */
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
