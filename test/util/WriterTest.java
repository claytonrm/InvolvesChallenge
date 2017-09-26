package util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import util.Writer;

public class WriterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private Path path;
	
	@Before
	public void setUp() throws Exception {
		path = Paths.get("files/test.csv");
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown() throws Exception {
		Files.delete(path);
	}

	@Test
	public void shouldCreateACsvFile() throws IOException {
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		fileContent.put("header", createHeader());
		fileContent.put("content", createContent());
		final String fileName = path.toAbsolutePath().toString().toString();
		
		Writer.createCsvFile(fileName.toString(), fileContent);
		final File csv = new File(fileName);
		final BufferedReader reader = Files.newBufferedReader(path);

		Assert.assertTrue(csv.exists());
		Assert.assertNotNull(reader.readLine());
	}
	
	@Test
	public void shouldPrintAnErrorThereIsNoContentToWrite() throws IOException {
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		final String fileName = path.toAbsolutePath().toString().toString();

		Writer.createCsvFile(fileName.toString(), fileContent);

		Assert.assertEquals("There's no content to write.\n", errContent.toString());
	}
	
	private List<String[]> createHeader() {
		final String[] columns = new String[] {"ibge_id", "uf", "name", "capital", "lon", "lat", 
				"no_accents", "alternative_names", "microregion", "mesoregion"};
		
		final List<String[]> header = new ArrayList<>();
		header.add(columns);
		return header;
	}
	
	private List<String[]> createContent() {
		final String[] row1 = new String[] {"1100015", "RO", "Alta Floresta D'Oeste", "-61.9998238963", 
				"-11.9355403048", "Alta Floresta D'Oeste", "Cacoal", "Leste Rondoniense"};
		final String[] row2 = new String[] {"1501402", "PA", "Belém", "true", "-48.4878256875", 
				"-1.459845", "Belem", "", "Belém", "Metropolitana de Belém"};

		final List<String[]> content = new ArrayList<>();
		content.add(row1);
		content.add(row2);
		return content;
	}
	
}
