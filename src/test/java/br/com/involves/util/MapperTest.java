package br.com.involves.util;

import org.junit.Before;
import org.junit.BeforeClass;

import br.com.involves.annotation.CSVProperty;

public class MapperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void shouldConvertARowToObject() {
//		final String[] header = createHeader().get(0);
//		final String[] columns = createContent().get(0);
//		
//		final TestProperty expeted = new TestProperty();
//		
//		Mapper.convertCsvRowToObject(header, columns, TestProperty.class);
//	}

//	private List<String[]> createContent() {
//		final String[] row1 = new String[] {"1100015", "RO", "true", "-61.9998238963"};
//		final String[] row2 = new String[] {"1501402", "PA", "", "-48.4878256875"};
//
//		final List<String[]> content = new ArrayList<>();
//		content.add(row1);
//		content.add(row2);
//		return content;
//	}
//	
//
//	private List<String[]> createHeader() {
//		final String[] columns = new String[] {"long_property", "string_property", "boolean_property", "double_property"};
//		
//		final List<String[]> header = new ArrayList<>();
//		header.add(columns);
//		return header;
//	}
	
	class TestProperty {
		
		@CSVProperty(column = "long_property")
		private Long longProperty;

		@CSVProperty(column = "string_property")
		private String stringProperty;

		@CSVProperty(column = "boolean_property")
		private Boolean booleanProperty;

		@CSVProperty(column = "double_property")
		private Double doubleProperty;
		
		public Long getLongProperty() {
			return longProperty;
		}
		
		public void setLongProperty(final Long longProperty) {
			this.longProperty = longProperty;
		}

		public String getStringProperty() {
			return stringProperty;
		}
		
		public void setStringProperty(final String stringProperty) {
			this.stringProperty = stringProperty;
		}

		public Boolean getBooleanProperty() {
			return booleanProperty;
		}
		
		public void setBooleanProperty(final Boolean booleanProperty) {
			this.booleanProperty = booleanProperty;
		}
		
		public Double getDoubleProperty() {
			return doubleProperty;
		}
		
		public void setDoubleProperty(final Double doubleProperty) {
			this.doubleProperty = doubleProperty;
		}
	}

}
