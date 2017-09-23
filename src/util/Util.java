package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.CSVProperty;

public class Util {
	
	public static Object getAttributeValue(final Object o, final String property) {
		final Method[] methods = o.getClass().getDeclaredMethods();
		try {
			for (Method method : methods) {
				if (method.isAnnotationPresent(CSVProperty.class)) {
					for (Annotation annotation : method.getAnnotations()) {
						if (property.equals(((CSVProperty) annotation).column())) {
							return method.invoke(o);
						}
					}
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isEqual(final Object attributeValue, final Object anotherValue) {
		if (attributeValue instanceof Long) {
			return ((Long) attributeValue).equals((Long) anotherValue);
		}

		if (attributeValue instanceof Double) {
			return ((Double) attributeValue).equals((Double) anotherValue);
		}
		
		if (attributeValue instanceof Boolean) {
			return ((Boolean) attributeValue).equals((Boolean) anotherValue);
		}
		
		return attributeValue.equals(anotherValue);
		
	}
	
}

