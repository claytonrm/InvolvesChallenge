package util;

import java.nio.file.Path;
import java.nio.file.Paths;

import controller.CityController;
import controller.Controller;

public class DataSetAssistant {
	
	private static final int MIN_PARAM_NUMBER = 2;
	private static final int MAX_PARAM_NUMBER = 3;
	
	private Controller controller;
	private static Path path;
	
	public DataSetAssistant(final String fileName) {
		path = Paths.get("files/cidades.csv");
		controller = new CityController();
	}
	
	public void run() {
		controller.loadCsv(path.toAbsolutePath().toString(), ",");
		
		String[] params = new String[] {};
		assist(params);
	}

	private void assist(String[] params) {
		
		if (!validateParams(params)) {
			return;
		};
		
		assist(params);
		
		if (params[0].equalsIgnoreCase("count")) {
			
			if (params[1].equalsIgnoreCase("*")) {
				final long numberTotal = controller.countAll();
				
				System.out.println(numberTotal);
				return;
			}
			
			if (params[1].equalsIgnoreCase("distinct")) {
				final String property = params[2].replaceAll("[\\[\\]]", "").toLowerCase();
				final long numberTotalByProperty = controller.countDistinctBy(property);
				
				System.out.println(numberTotalByProperty);
				return;
			}
			
			System.err.println("Invalid param!");
		}
		
		if (params[0].equalsIgnoreCase("filter")) {
			final String property = params[1].toLowerCase();
			final String value = params[2];
			
			if (property != null && value != null) {
				final String result = controller.filterBy(property, value);
				System.out.println(result);
			}
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

}
