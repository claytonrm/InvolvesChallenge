package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.CSVProperty;

public class Reflection {
	
	public static Object getAttributeValue(final Object o, final String property) {
		try {
			final Method methodTypeGet = getMethodByPropertyName(o, property, 0);
			return methodTypeGet.invoke(o);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			Message.printError(e.getMessage());
		}
		return null;
	}
	
	public static Method getMethodByPropertyName(final Object o, final String property, final int paramNumber) {
		final Method[] methods = o.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(CSVProperty.class) && method.getParameterCount() == paramNumber) {
				for (Annotation annotation : method.getAnnotations()) {
					if (property.equals(((CSVProperty) annotation).column())) {
						return method;
					}
				}
			}
		}
		return null;
	}
	
	public static void setValueToAttribute(final Object o, final Object value, final String attribute) {
		try {
			final Method methodTypeGet = getMethodByPropertyName(o, attribute, 1);
			methodTypeGet.invoke(o, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Message.printError(e.getMessage());
		}
	}
	
	public static boolean isEqual(final Object attributeValue, final Object anotherValue) {
		if (attributeValue == null || anotherValue == null) {
			return false;
		}
		
		if (attributeValue instanceof Long) {
			return ((Long) attributeValue).equals((Long) anotherValue);
		}

		if (attributeValue instanceof Double) {
			return ((Double) attributeValue).equals((Double) anotherValue);
		}
		
		if (attributeValue instanceof Boolean) {
			return ((Boolean) attributeValue).equals(Boolean.valueOf((String) anotherValue));
		}
		
		return attributeValue.equals(anotherValue);
		
	}
	
}

