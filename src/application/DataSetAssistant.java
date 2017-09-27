package application;

import java.nio.file.Path;
import java.nio.file.Paths;

import controller.CityController;
import controller.Controller;
import enums.Param;
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

	public void assist(final String[] params) {
		
		if (!validateParamsNumber(params)) {
			Message.printError("Invalid params number!");
			return;
		};
		
		final Param paramFilter = Param.get(new String[] {params[0].toLowerCase()});
		final Param inputParam = paramFilter != null ? paramFilter : Param.get(new String[] {params[0].toLowerCase(), params[1].toLowerCase()});
		
		if (Param.COUNT_ALL.equals(inputParam)) {
			final long numberTotal = controller.countAll();
			Message.print(String.valueOf(numberTotal));
			return;
		}
		
		if (Param.COUNT_DISTINCT.equals(inputParam)) {
			final String propertyName = controller.getProperty(params[2]);
			
			if (propertyName == null) {
				Message.printError("This property does not exist!");
				return;
			}

			final long totalByDistinctProperty = controller.countDistinctBy(propertyName);
			Message.print(String.valueOf(totalByDistinctProperty));
			return;
		}
		
		if (Param.FILTER.equals(inputParam)) {
			final String propertyName = controller.getProperty(params[1]);
			final String propertyValue = params[2];

			if (propertyName != null) {
				final String cleanedValue = propertyValue.replaceAll("[\\[\\]]", "");
				final String result = controller.filterBy(propertyName, cleanedValue);
				Message.print(result);
			}
			
			Message.printError("This property does not exist!");
			return;
		}
		
		Message.printError("Invalid params!");
	}

	private boolean validateParamsNumber(final String[] params) {
		return params != null && (params.length == MIN_PARAM_NUMBER || 
				params.length == MAX_PARAM_NUMBER); 
	}
	
}
