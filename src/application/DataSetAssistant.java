package application;

import java.nio.file.Path;
import java.nio.file.Paths;

import controller.CityController;
import controller.Controller;
import util.Message;

public class DataSetAssistant {
	
	private static final int MIN_PARAM_NUMBER = 2;
	private static final int MAX_PARAM_NUMBER = 3;
	
	private Controller controller;
	private Path path;
	
	public DataSetAssistant(final String fileName) {
		path = Paths.get(fileName);
		controller = new CityController();
		controller.loadCsv(path.toAbsolutePath().toString(), Message.CSV_SEPARATOR);
	}

	public void assist(String[] params) {
		
		if (!validateParams(params)) {
			return;
		};
		
		if (params[0].equalsIgnoreCase("count")) {
			
			if (params[1].equalsIgnoreCase("*")) {
				final long numberTotal = controller.countAll();
				
				Message.print(String.valueOf(numberTotal));
				return;
			}
			
			if (params[1].equalsIgnoreCase("distinct")) {
				final String property = params[2].replaceAll("[\\[\\]]", "").toLowerCase();
				final long numberTotalByProperty = controller.countDistinctBy(property);
				
				Message.print(String.valueOf(numberTotalByProperty));
				return;
			}
			
			Message.invalidParam();
		}
		
		if (params[0].equalsIgnoreCase("filter")) {
			final String property = params[1].replaceAll("[\\[\\]]", "").toLowerCase();
			final String value = params[2].replaceAll("[\\[\\]]", "");
			
			if (property != null && value != null) {
				final String result = controller.filterBy(property, value);
				Message.print(result);
			}
			return;
		}
		
		Message.invalidParam();
	}

	private boolean validateParams(final String[] params) {
		if (params.length != MIN_PARAM_NUMBER && params.length != MAX_PARAM_NUMBER) {
			return false;
		}
		return true;
	}
	
}
