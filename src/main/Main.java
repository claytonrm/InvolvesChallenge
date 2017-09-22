package main;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.City;
import service.CityService;
import service.Service;
import util.Reader;

public class Main {
	
	private static Service<City> service = new CityService();
	private static String fileName = "files/cidades.csv";
	
	public static void main(String[] args) {
		initializateDataSet(fileName);
		System.out.println(service.findAll().size());
	}

	private static void initializateDataSet(String fileName) {
		final Map<String, List<String[]>> fullContent = Reader.readCsv("files/cidades.csv", ",", true);
		final List<String[]> records = fullContent.get("content");
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
	

}
