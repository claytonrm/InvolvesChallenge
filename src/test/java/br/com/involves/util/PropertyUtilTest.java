package br.com.involves.util;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.annotation.CSVProperty;

public class PropertyUtilTest {
	
	@Test
	public void shouldReturnObjectAsPropertyType() {
		final TestProperty testProperty = new TestProperty();
		testProperty.setLongProperty(1L);
		testProperty.setDoubleProperty(10.0);
		testProperty.setBooleanProperty(true);
		testProperty.setStringProperty("test");
		
		final Object objectLong = PropertyUtil.getAttributeValue(testProperty, "long_property");
		final Object objectDouble = PropertyUtil.getAttributeValue(testProperty, "double_property");
		final Object objectBoolean = PropertyUtil.getAttributeValue(testProperty, "boolean_property");
		final Object objectString = PropertyUtil.getAttributeValue(testProperty, "string_property");
		
		Assert.assertTrue(objectLong instanceof Long);
		Assert.assertTrue(objectDouble instanceof Double);
		Assert.assertTrue(objectBoolean instanceof Boolean);
		Assert.assertTrue(objectString instanceof String);
	}
	
	@Test
	public void shouldSetALongValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		PropertyUtil.setValueToAttribute(testProperty, 1L, "long_property");
		
		Assert.assertTrue(testProperty.getLongProperty().equals(1L));
	}
	
	@Test
	public void shouldSetABooleanValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		PropertyUtil.setValueToAttribute(testProperty, true, "boolean_property");
		
		Assert.assertEquals(true, testProperty.getBooleanProperty());
	}
	
	@Test
	public void shouldSetADoubleValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		PropertyUtil.setValueToAttribute(testProperty, 5.0, "double_property");
		
		Assert.assertTrue(testProperty.getDoubleProperty().equals(5.0));
	}
	
	@Test
	public void shouldSetAStringValueIntoTheProperty() {
		final TestProperty testProperty = new TestProperty();
		
		PropertyUtil.setValueToAttribute(testProperty, "do it", "string_property");
		
		Assert.assertEquals("do it", testProperty.getStringProperty());
	}
	
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
