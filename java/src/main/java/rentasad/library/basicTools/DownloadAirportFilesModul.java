package rentasad.library.basicTools;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import rentasad.library.configFileTool.ConfigFileTool;
import rentasad.library.configFileTool.ConfigFileToolException;

public class DownloadAirportFilesModul {

	public final static String PARAMETER_NAME_AIRPORTS = "airports";
	public final static String PARAMETER_NAME_AIRPORT_FREQUENCIES = "airtport-frequencies";
	public final static String PARAMETER_NAME_RUNWAYS = "runways";
	public final static String PARAMETER_NAME_NAVAIDS = "navaids";
	public final static String PARAMETER_NAME_COUNTRIES = "countries";
	public final static String PARAMETER_NAME_REGIONS = "regions";

	public static void airportFileDownloader() throws IOException, ConfigFileToolException {

		Map<String, String> downloadConfigMap = ConfigFileTool.readConfiguration("resources/config/downloadLinks.ini",
				"AIRPORT_URLS");
//		String airportsUrl = downloadConfigMap.get(PARAMETER_NAME_AIRPORTS);
//		String airprtFrequenciesUrl = downloadConfigMap.get(PARAMETER_NAME_AIRPORT_FREQUENCIES);
//		String runwaysUrl = downloadConfigMap.get(PARAMETER_NAME_RUNWAYS);
//		String navAidsUrl = downloadConfigMap.get(PARAMETER_NAME_NAVAIDS);
//		String countriesUrl = downloadConfigMap.get(PARAMETER_NAME_COUNTRIES);
//		String regionsUrl = downloadConfigMap.get(PARAMETER_NAME_REGIONS);
//		
		Set<String> keySet = downloadConfigMap.keySet();
		for (String key : keySet) {
			String urlString = downloadConfigMap.get(key);
			System.out.println("Downloade " + key + ".csv");
			FileDownloader.downloadFile(urlString, new File("resources/download/"+key+".csv"));
		}

	}
}
