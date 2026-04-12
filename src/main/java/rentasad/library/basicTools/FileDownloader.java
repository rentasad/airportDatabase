package rentasad.library.basicTools;

import lombok.extern.java.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author matthi
 *
 */
@Log
public class FileDownloader {

	public static void downloadFile(String url, File targetFile) throws IOException {
		try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			log.severe("Failed to download file from " + url + ": " + e.getMessage());
			throw e;
		}
	}
}
