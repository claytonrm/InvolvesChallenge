package br.com.involves.util;

public class Mapper {

	public static void convertCsvRowToObject(final String[] header, final String[] columns, Class<?> clazz) {
		for (int i = 0; i < header.length; i++) {
			try {
				PropertyUtil.setValueToAttribute(clazz.newInstance(), columns[i], header[i]);
			} catch (InstantiationException | IllegalAccessException e) {
				Message.printError("Cannot generate object from CSV row!");
			}
		}
	}

}
