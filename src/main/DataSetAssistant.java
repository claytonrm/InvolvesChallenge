package main;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.City;
import service.CityService;
import service.Service;
import util.Reader;

public class DataSetAssistant {
	
	private static final int MIN_PARAM_NUMBER = 2;
	private static final int MAX_PARAM_NUMBER = 3;
	
	private Service<City> service = new CityService();
	
	public void assist(String[] params) {
		if (!validateParams(params)) {
			return;
		};
		run(params);
	}

	private void run(String[] params) {
		
		if (params[0].equalsIgnoreCase("count")) {
			
			if (params[1].equalsIgnoreCase("*")) {
				final int numberTotal = service.findAll().size();
				
				System.out.println(numberTotal);
				return;
			}
			
			if (params[1].equalsIgnoreCase("distinct")) {
				
				return;
			}
			
			System.err.println("Invalid param!");
		}
		
		if (params[0].equalsIgnoreCase("filter")) {
			return;
		}
		System.err.println("Invalid param!");
		
	}

	private boolean validateParams(final String[] params) {
		if (params.length != MIN_PARAM_NUMBER && params.length != MAX_PARAM_NUMBER) {
			return false;
		}
		return true;
	}

	public void setInput(final String csvFileName, final String separator) {
		final Map<String, List<String[]>> fullContent = Reader.readCsv(csvFileName, separator, true);
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
