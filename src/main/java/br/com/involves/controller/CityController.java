package br.com.involves.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.involves.model.City;
import br.com.involves.service.CityService;
import br.com.involves.service.Service;
import br.com.involves.util.Message;
import br.com.involves.util.Reader;

public class CityController implements Controller {

	private Service<City> service;
	
	private Map<String, List<String[]>> fileContent;
	
	public CityController() {
		service = new CityService();
	}
	
	@Override
	public void loadCsv(final String fileName, final String separador) {
		fileContent = Reader.readCsv(fileName, separador, true);
		final List<String[]> records = fileContent.get("content");
		
		final Set<City> cities = new HashSet<>();
		
		//TODO XXX - Try to use that annotations
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
		service.insertAll(cities);
	}

	@Override
	public long countAll() {
		return service.findAll().size();
	}

	@Override
	public long countDistinctBy(final String property) {
		return service.findAllDistinctBy(property).size();
	}

	@Override
	public String filterBy(final String property, final Object value) {
		final StringBuilder sb = new StringBuilder(Message.HORIZONTAL_SEPARATOR);
		try {
			createOutput(sb, service.filterBy(property, value));
		} catch (NumberFormatException e) {
			Message.printError("Parameter is not of the expected type.");
		}
		return sb.toString();
	}

	@Override
	public String getProperty(final String property) {
		final String cleanedProperty = property.replaceAll(Message.PATTERN_REGEX_BRACKETS, "").toLowerCase();
		final int firstLine = 0;
		final String[] cityProperties = fileContent.get(Message.HEADER).get(firstLine);
		
		for (String propertyName : cityProperties) {
			if (propertyName.equals(cleanedProperty)) {
				return propertyName;
			}
		}
		
		return null;
	}
	
	private void createOutput(final StringBuilder sb, final List<City> cities) {
		final String header = String.join("|", fileContent.get(Message.HEADER).get(0));
		sb.append(header);
		sb.append(Message.NEW_LINE);
		sb.append(Message.HORIZONTAL_SEPARATOR);
		for (City city : cities) {
			sb.append(city);
			sb.append(Message.NEW_LINE);
		}
	}
}
