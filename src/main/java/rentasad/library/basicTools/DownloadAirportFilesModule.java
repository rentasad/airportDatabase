package rentasad.library.basicTools;

import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import rentasad.library.configFileTool.ConfigFileTool;
import rentasad.library.configFileTool.ConfigFileToolException;

@Log
public class DownloadAirportFilesModule {

	public final static String PARAMETER_NAME_AIRPORTS = "airports";
	public final static String PARAMETER_NAME_AIRPORT_FREQUENCIES = "airport-frequencies";
	public final static String PARAMETER_NAME_RUNWAYS = "runways";
	public final static String PARAMETER_NAME_NAVAIDS = "navaids";
	public final static String PARAMETER_NAME_COUNTRIES = "countries";
	public final static String PARAMETER_NAME_REGIONS = "regions";

	public static void airportFileDownloader() throws IOException, ConfigFileToolException {

		Map<String, String> downloadConfigMap = ConfigFileTool.readConfiguration("resources/config/downloadLinks.ini",
				"AIRPORT_URLS");
		Set<String> keySet = downloadConfigMap.keySet();
		for (String key : keySet) {
			String urlString = downloadConfigMap.get(key);
			log.info("Downloading " + key + ".csv");
			FileDownloader.downloadFile(urlString, new File("resources/download/" + key + ".csv"));
		}
	}
}
