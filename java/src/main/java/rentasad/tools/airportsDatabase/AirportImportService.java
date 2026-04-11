package rentasad.tools.airportsDatabase;

import lombok.extern.java.Log;
import rentasad.library.basicTools.DownloadAirportFilesModul;
import rentasad.tools.airportsDatabase.objects.*;

import java.util.List;

@Log
public class AirportImportService {

    private final CreateDatabaseTool dbTool;

    public AirportImportService(CreateDatabaseTool dbTool) {
        this.dbTool = dbTool;
    }

    public void importData() throws Exception {
        log.info("Starting airport data import process...");

        DownloadAirportFilesModul.airportFileDownloader();

        log.info("Parsing CSV files...");
        List<AirportsObject> airports = ParseAirportCsvFilesModul.parseAirportCsv("resources/download/airports.csv");
        List<AirportFrequenciesObjects> frequencies = ParseAirportCsvFilesModul.parseAirportFrequenciesCsv("resources/download/airport-frequencies.csv");
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
