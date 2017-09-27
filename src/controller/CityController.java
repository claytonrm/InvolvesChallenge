package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.City;
import service.CityService;
import service.Service;
import util.Reader;

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
		return service.countAll();
	}

	@Override
	public long countDistinctBy(final String property) {
		return service.countDistinctBy(property);
	}

	@Override
	public String filterBy(final String property, final Object value) {
		final List<City> cities = service.filterBy(property, value);
		
		if (cities.isEmpty()) {
			return null;
		}
		
		final String header = String.join(",", fileContent.get("header").get(0));
		final StringBuilder sb = new StringBuilder(header);
		
		sb.append("\n");
		for (City city : cities) {
			sb.append(city);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String getProperty(final String property) {
		if (property != null) {
			final String cleanedProperty = property.replaceAll("[\\[\\]]", "").toLowerCase();
			final int firstLine = 0;
			final String[] cityProperties = fileContent.get("header").get(firstLine);
			
			for (String propertyName : cityProperties) {
				if (propertyName.equals(cleanedProperty)) {
					return propertyName;
				}
			}
		}
		
		return null;
	}

}
