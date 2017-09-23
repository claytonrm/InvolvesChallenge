package test;

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

import main.DataSetAssistant;
import util.Writer;

public class DataSetAssistantTest {

	private static Path path;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private static DataSetAssistant dataSetAssistant;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		fileContent.put("header", createHeader());
		fileContent.put("content", createContent());
		
		path = Paths.get("files/test.csv");
		
		Writer.createCsvFile(path.toAbsolutePath().toString(), fileContent);
		
		dataSetAssistant = new DataSetAssistant();
		dataSetAssistant.setInput(path.toAbsolutePath().toString(), ",");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Files.delete(path);
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void shouldPrintTotalRecords() {
		final String[] params = new String[] {"count", "*"};
		
		dataSetAssistant.assist(params);
		
		Assert.assertEquals(2 + "\n", outContent.toString());
	}
	
	@Test
	public void shouldPrintAnErrorInvalidParam() {
		final String[] params = new String[] {"max", "*"};
		
		dataSetAssistant.assist(params);
		
		Assert.assertEquals("Invalid param!\n", errContent.toString());
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
