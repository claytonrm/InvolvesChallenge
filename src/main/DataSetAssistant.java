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
				final long numberTotal = service.countAll();
				
				System.out.println(numberTotal);
				return;
			}
			
			if (params[1].equalsIgnoreCase("distinct")) {
				final String property = params[2].replaceAll("[\\[\\]]", "").toLowerCase();
				final long numberTotalByProperty = service.countDistinctBy(property);
				
				System.out.println(numberTotalByProperty);
				return;
			}
			
			System.err.println("Invalid param!");
		}
		
		if (params[0].equalsIgnoreCase("filter")) {
			final String property = params[1].toLowerCase();
			final String value = params[2];
			
			if (property != null && value != null) {
				service.filterBy(property, value);
			}
			
			final String mock = "ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion\n" + 
					"1721000,TO,Palmas,true,-48.3510437082,-10.1632533268,Palmas,,Porto Nacional,Oriental do Tocantins\n" + 
					"4117602,PR,Palmas,,-51.9887738877,-26.481472515,Palmas,,Palmas,Centro-Sul Paranaense\n";
			
			System.out.println(mock);
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

	public void load(final String csvFileName, final String separator) {
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
