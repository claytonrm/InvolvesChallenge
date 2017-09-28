package br.com.involves.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import br.com.involves.annotation.CSVProperty;

public class PropertyUtil {
	
	public static Object getAttributeValue(final Object o, final String property) {
		try {
			return new PropertyDescriptor(getFieldByPropertyName(o, property).getName(), o.getClass()).getReadMethod().invoke(o);
		} catch (IllegalAccessException | InvocationTargetException 
				| IllegalArgumentException | IntrospectionException e) {
			Message.printError(e.getMessage());
		}
		return null;
	}
	
	private static Field getFieldByPropertyName(final Object o, final String propertyName) {
		final Field[] fields = o.getClass().getDeclaredFields();
		for (Field field : fields) {
			for (Annotation annotation : field.getAnnotations()) {
				if (propertyName.equals(((CSVProperty) annotation).column())) {
					return field;
				}
			}
		}
		return null;
	}
	
	public static void setValueToAttribute(final Object o, final Object value, final String attribute) {
		try {
			new PropertyDescriptor(getFieldByPropertyName(o, attribute).getName(), o.getClass()).getWriteMethod().invoke(o, value);
		} catch (IllegalArgumentException | InvocationTargetException 
				| IntrospectionException | IllegalAccessException e) {
			Message.printError(e.getMessage());
		}
	}
	
	public static boolean isEqual(final Object attributeValue, final Object anotherValue) {
		if (attributeValue == null || anotherValue == null) {
			return false;
		}
		
		if (anotherValue instanceof String) {
			if (attributeValue instanceof Long) {
				return ((Long) attributeValue).equals(Long.valueOf((String) anotherValue));
			}
			
			if (attributeValue instanceof Double) {
				return ((Double) attributeValue).equals(Double.valueOf((String) anotherValue));
			}
			
			if (attributeValue instanceof Boolean) {
				return ((Boolean) attributeValue).equals(Boolean.valueOf((String) anotherValue));
			}
		}
		
		return attributeValue.equals(anotherValue);
		
	}
	
}

