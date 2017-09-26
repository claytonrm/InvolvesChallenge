package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapperTest {

	private static final String HEADER = "header";
	private static final String CONTENT = "content";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldConvertARowToObject() {
		final Map<String, List<String[]>> fileContent = new HashMap<>();
		fileContent.put(HEADER, createHeader());
		fileContent.put(CONTENT, createContent());
		
//		Assert.assertThat(Mapper.convertCsvRowToObject(columns, City.class));
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
	

	private List<String[]> createHeader() {
		final String[] columns = new String[] {"ibge_id", "uf", "name", "capital", "lon", "lat", 
				"no_accents", "alternative_names", "microregion", "mesoregion"};
		
		final List<String[]> header = new ArrayList<>();
		header.add(columns);
		return header;
	}

}
