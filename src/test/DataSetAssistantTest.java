package test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.City;
import util.Reader;

public class DataSetAssistantTest {

	private static final String SEPARATOR = ",";
	private static String fileName = "files/test.csv";
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		createAnyCsvContent(fileName);
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void shouldInicializeDataSet() {
		final Map<String, List<String[]>> fullContent = Reader.readCsv(fileName, SEPARATOR, true);
		final List<String[]> records = fullContent.get("content");
		
		final Set<City> cities = new HashSet<>();
		
		for (String[] column : records) {
			final City city = new City();
			city.setIbgeId(Long.parseLong(column[0]));
			city.setUf(column[1]);
			city.setName(column[2]);
			city.setCapital(Boolean.valueOf(column[3]));
			city.setLongitude(Double.valueOf(column[4]));
			city.setLatitude(Double.valueOf(column[5]));
			city.setNoAccents(column[6]);
			city.setAlternativeNames(column[7]);
			city.setMicroregion(column[8]);
			city.setMesoregion(column[9]);
			cities.add(city);
		}
//		service.insertAll(cities);
	}
	
	private static void createAnyCsvContent(final String fileName) throws Exception {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			final Set<City> cities = new HashSet<>(createAnyCities());
			
			for (City cityItem : cities) {
				writer.append(cityItem.getIbgeId().toString()).append(SEPARATOR)
				.append(cityItem.getName()).append(SEPARATOR)
				.append(cityItem.getUf()).append(SEPARATOR);
			}
			
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		} finally {
			writer.close();
		}
	}
	
	private static List<City> createAnyCities() {
		final City c1 = createCity(123L, "Criciúma", "SC");
		final City c2 = createCity(456L, "Gravatal", "SC");
		final City c3 = createCity(789L, "São Paulo", "SP");
		final City c4 = createCity(111L, "Florianópolis", "SC");
		return Arrays.asList(c1, c2, c3, c4);
	}

	private static City createCity(final Long ibgeId, final String name, final String uf) {
		final City city = new City();
		city.setIbgeId(ibgeId);
		city.setName(name);
		city.setUf(uf);
		return city;
	}

}
