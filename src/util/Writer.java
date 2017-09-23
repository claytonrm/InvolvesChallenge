package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Writer {

	public static void createCsvFile(final String fileName, final Map<String, List<String[]>> fileContent) {
		try (FileWriter writer = new FileWriter(fileName)) {
			final List<String[]> header = fileContent.get("header");
			final List<String[]> content = fileContent.get("content");
			
			if (header != null) {
				writeColumns(writer, header);
			}
			writeColumns(writer, content);

		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	private static void writeColumns(final FileWriter writer, final List<String[]> record) throws IOException {
		if (record == null) {
			System.err.println("There's no content to write.");
			return;
		}
		
		for (String[] columns : record) {
			writer.append(String.join(",", columns));
			writer.append("\n");
		}
	}

}