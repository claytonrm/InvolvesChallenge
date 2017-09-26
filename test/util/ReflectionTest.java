package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import annotation.CSVProperty;

public class ReflectionTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnObjectAsPropertyType() {
		final TestProperty testProperty = new TestProperty();
		testProperty.setLongProperty(1L);
		testProperty.setDoubleProperty(10.0);
		testProperty.setBooleanProperty(true);
		testProperty.setStringProperty("test");
		
		final Object objectLong = Reflection.getAttributeValue(testProperty, "long_property");
		final Object objectDouble = Reflection.getAttributeValue(testProperty, "double_property");
		final Object objectBoolean = Reflection.getAttributeValue(testProperty, "boolean_property");
		final Object objectString = Reflection.getAttributeValue(testProperty, "string_property");
		
		Assert.assertTrue(objectLong instanceof Long);
		Assert.assertTrue(objectDouble instanceof Double);
		Assert.assertTrue(objectBoolean instanceof Boolean);
		Assert.assertTrue(objectString instanceof String);
	}
	
	@Test
	public void shouldSetALongValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		Reflection.setValueToAttribute(testProperty, 1L, "long_property");
		
		Assert.assertTrue(testProperty.getLongProperty().equals(1L));
	}
	
	@Test
	public void shouldSetABooleanValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		Reflection.setValueToAttribute(testProperty, true, "boolean_property");
		
		Assert.assertEquals(true, testProperty.getBooleanProperty());
	}
	
	@Test
	public void shouldSetADoubleValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		Reflection.setValueToAttribute(testProperty, 5.0, "double_property");
		
		Assert.assertTrue(testProperty.getDoubleProperty().equals(5.0));
	}
	
	@Test
	public void shouldSetAStringValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		Reflection.setValueToAttribute(testProperty, "do it", "string_property");
		
		Assert.assertEquals("do it", testProperty.getStringProperty());
	}
	
	class TestProperty {
		
		private Long longProperty;
		private String stringProperty;
		private Boolean booleanProperty;
		private Double doubleProperty;
		
		@CSVProperty(column = "long_property")
		public Long getLongProperty() {
			return longProperty;
		}
		
		@CSVProperty(column = "long_property")
		public void setLongProperty(final Long longProperty) {
			this.longProperty = longProperty;
		}

		@CSVProperty(column = "string_property")
		public String getStringProperty() {
			return stringProperty;
		}
		
		@CSVProperty(column = "string_property")
		public void setStringProperty(final String stringProperty) {
			this.stringProperty = stringProperty;
		}

		@CSVProperty(column = "boolean_property")
		public Boolean getBooleanProperty() {
			return booleanProperty;
		}
		
		@CSVProperty(column = "boolean_property")
		public void setBooleanProperty(final Boolean booleanProperty) {
			this.booleanProperty = booleanProperty;
		}
		
		@CSVProperty(column = "double_property")
		public Double getDoubleProperty() {
			return doubleProperty;
		}
		
		@CSVProperty(column = "double_property")
		public void setDoubleProperty(final Double doubleProperty) {
			this.doubleProperty = doubleProperty;
		}
	}

}
