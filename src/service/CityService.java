package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.City;
import util.Reader;

public class CityService {

	private static List<City> cities;
	
	public static void initialize() {
		final Map<String, List<String[]>> fullContent = Reader.readCsv("files/cidades.csv", ",", true);
		final List<String[]> records = fullContent.get("content");
		cities = new ArrayList<>();
		
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
		
	}

	public static List<City> findAll() {
		if (cities == null) {
			throw new IllegalArgumentException("There're no cities available. Plese initialize the cities before search by them.");
		}
		
		return cities;
	}

	public static List<City> findByName(final String cityName) {
		final List<City> result = cities.stream()
			     .filter(item -> item.getName().equals(cityName))
			     .collect(Collectors.toList());
		return result;
	}
}
