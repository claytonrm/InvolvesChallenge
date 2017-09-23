package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Reader;
import util.Writer;

public class ReaderTest {
	
	private static final String SEPARATOR = ",";
	
	private static Path pathNameWithHeader;
	private static Path pathNameWithoutHeader;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pathNameWithHeader = Paths.get("files/fileWithHeader.csv");
		pathNameWithoutHeader = Paths.get("files/fileWithoutHeader.csv");
		
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		fileContent.put("header", createHeader());
		fileContent.put("content", createContent());
		Writer.createCsvFile(pathNameWithHeader.toAbsolutePath().toString(), fileContent);
		
		final Map<String, List<String[]>> fileContentBare = fileContent;
		fileContentBare.remove("header");
		Writer.createCsvFile(pathNameWithoutHeader.toAbsolutePath().toString(), fileContentBare);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Files.delete(pathNameWithHeader);
		Files.delete(pathNameWithoutHeader);
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void shouldReadACsvFileWithoutHeader() {
		final Map<String, List<String[]>> content = Reader.readCsv(pathNameWithoutHeader.toAbsolutePath().toString(), SEPARATOR);
		
		assertNull(content.get("header"));
		assertNotNull(content.get("content"));
	}
	
	@Test
	public void shouldReadACsvFileWithHeader() {
		final boolean containsHeader = true;
		final Map<String, List<String[]>> content = Reader.readCsv(pathNameWithHeader.toAbsolutePath().toString(), SEPARATOR, containsHeader);
		
		assertNotNull(content.get("header"));
		assertNotNull(content.get("content"));
	}
	
	@Test
	public void shouldPrintAnErrorCannotReadThisFile() {
		final boolean containsHeader = true;
		final String anotherFile = "files/cidadesx.csv";
		Reader.readCsv(anotherFile, SEPARATOR, containsHeader);
		
		Assert.assertEquals("Cannot read this file \"%s\".\n", errContent.toString());
	}
	
	private static List<String[]> createHeader() {
		final String[] columns = new String[] {"ibge_id", "uf", "name", "capital", "lon", "lat", 
				"no_accents", "alternative_names", "microregion", "mesoregion"};
		
		final List<String[]> header = new ArrayList<>();
		header.add(columns);
		return header;
	}
	
	private static List<String[]> createContent() {
		final String[] row1 = new String[] {"1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", 
				"-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"};
		final String[] row2 = new String[] {"1501402", "PA", "Belém", "true", "-48.4878256875", 
				"-1.459845", "Belem", "", "Belém", "Metropolitana de Belém"};

		final List<String[]> content = new ArrayList<>();
		content.add(row1);
		content.add(row2);
		return content;
	}
}
