package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
		dataSetAssistant.load(path.toAbsolutePath().toString(), ",");
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
		
		Assert.assertEquals(8 + "\n", outContent.toString());
	}
	
	@Test
	public void shouldPrintTotalDistinctPropertyRecord() {
		final String[] params = new String[] {"count", "distinct", "[name]"};
		
		dataSetAssistant.assist(params);
		
		Assert.assertEquals(6 + "\n", outContent.toString());
	}
	
	@Test
	public void shouldFilterObjectByPropertyValue() {
		final String[] header = createHeader().get(0);
		final List<String[]> content = createContent();

		final String[] params = new String[] {"filter", "[name]", "[Palmas]"};
		
		dataSetAssistant.assist(params);

		final StringBuilder out = new StringBuilder(String.join(",", header));
		out.append("\n");
		out.append(String.join(",", content.get(4)));
		out.append("\n");
		out.append(String.join(",", content.get(7)));
		out.append("\n");
		
		Assert.assertEquals(out.toString() + "\n", outContent.toString());
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

		final String[] row3 = new String[] {"1301704", "AM", "Humaitá", "", "-63.0266980219", "-7.5122249506", 
				"Humaita", "", "Madeira", "Sul Amazonense"};
		
		final String[] row4 = new String[] {"4309704", "RS", "Humaitá", "", "-53.9765055737", "-27.5614898161", 
				"Humaita", "", "Três Passos", "Noroeste Rio-Grandense"};

		final String[] row5 = new String[] {"1721000", "TO", "Palmas", "true", "-48.3510437082", "-10.1632533268", 
				"Palmas", "", "Porto Nacional", "Oriental do Tocantins"};
		
		final String[] row6 = new String[] {"2408102", "RN", "Natal", "true", "-35.2522547281", "-5.7508985376", 
				"Natal", "", "Natal", "Leste Potiguar"};
		
		final String[] row7 = new String[] {"4205407", "SC", "Florianópolis", "true", "-48.5476373782", "-27.5877955486", 
				"Florianopolis", "", "Florianópolis", "Grande Florianópolis"};
		
		final String[] row8 = new String[] {"4117602", "PR", "Palmas", "", "-51.9887738877", "-26.481472515", 
				"Palmas", "", "Palmas", "Centro-Sul Paranaense"};
		
		return Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8);
	}
	
}
