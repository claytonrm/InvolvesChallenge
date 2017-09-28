package br.com.involves.controller;

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

import br.com.involves.util.Writer;

public class CityControllerTest {

	private static Path path;
	private static final String FILE_NAME = "src/test/resources/test.csv";
	
	private Controller controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		fileContent.put("header", createHeader());
		fileContent.put("content", createContent());
		
		path = Paths.get(FILE_NAME);
		
		Writer.createCsvFile(path.toAbsolutePath().toString(), fileContent);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Files.delete(path);
	}

	@Before
	public void setUp() throws Exception {
		controller = new CityController();
	}

	@Test
	public void shouldLoadACsvFileAndCountAllRecords() {
		controller.loadCsv(FILE_NAME, ",");
		
		Assert.assertEquals(8, controller.countAll());
	}
	
	@Test
	public void shouldCountAllCitiesByDistinctProperty() {
		controller.loadCsv(FILE_NAME, ",");
		
		Assert.assertEquals(6, controller.countDistinctBy("name"));
	}
	
	@Test
	public void shouldFilterObjectByPropertyValue() {
		controller.loadCsv(FILE_NAME, ",");
		
		final String[] header = createHeader().get(0);
		final List<String[]> content = createContent();

		final String out = controller.filterBy("name", "Palmas");
		
		final StringBuilder expected = new StringBuilder();
		expected.append("\n");
		expected.append(String.join("|", content.get(4)));
		expected.append("\n");
		expected.append(String.join("|", content.get(7)));
		expected.append("\n");
		
		Assert.assertTrue(out.toString().contains(String.join("|", header)));
		Assert.assertTrue(out.toString().contains(expected));
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
