package br.com.involves.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

	/**
	 * @param fileName - The entire path of the file.
	 * @param separator - The separator to separate in columns.
	 * @param containsHeader - Indicates whether the file contains a header.
	 * @return A Map<String, List<String[]> which key is header and content and value is the columns
	 * from csv file.
	 */
	public static Map<String, List<String[]>> readCsv(final String fileName, final String separator, final boolean containsHeader) {
		final Path path = Paths.get(fileName);
		final Map<String, List<String[]>> fullContent = new HashMap<>();
		
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			final List<String[]> content = new ArrayList<>();
			
			String line;
			while ((line = reader.readLine()) != null) {
				final String[] columns = line.split(separator);
				final List<String[]> header = fullContent.get(Constants.HEADER);

				if (containsHeader && header == null) {
					final List<String[]> firstLine = new ArrayList<>();
					firstLine.add(columns);
					fullContent.put(Constants.HEADER, firstLine);
					continue;
				}
				content.add(columns);
			}
			
			fullContent.put(Constants.CONTENT, content);
		} catch (IOException e) {
			Message.printError("Cannot read this file." + e.getMessage());
		}

		return fullContent;
	}
	
	/**
	 * @param fileName - The entire path of the file.
	 * @param separator - The separator to separate in columns.
	 * @return A Map<String, List<String[]> which contains a key \"header\" and \"content\" and value are columns
	 * from csv file.
	 */
	public static Map<String, List<String[]>> readCsv(final String fileName, final String separator) {
		return readCsv(fileName, separator, false);
	}

}
