package br.com.involves.controller;

public interface Controller {

	void loadCsv(final String fileName, final String separador);
	
	long countAll();
	
	long countDistinctBy(final String property);
	
	String filterBy(final String property, final Object value);
	
	String getProperty(final String propertyName);
	
}
