package br.com.involves.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.involves.controller.CityController;
import br.com.involves.controller.Controller;
import br.com.involves.enums.ParamCommand;
import br.com.involves.util.Message;

public class DataSetAssistant {

	private Controller controller;
	private Path path;
	
	public DataSetAssistant(final String fileName) {
		path = Paths.get(fileName);
		controller = new CityController();
		controller.loadCsv(path.toAbsolutePath().toString(), Message.CSV_SEPARATOR);
	}

	public void assist(final String params) {
		
		final ParamCommand commandParam = ParamCommand.get(params);
		
		if (commandParam == null) {
			Message.printError("Invalid parameters! The expected commands are: " + ParamCommand.showAllCommandSintax());
			return;
		}
		
		executeParams(commandParam, params);
	}

	private void executeParams(final ParamCommand paramCommand, final String params) {
		final Pattern pattern = Pattern.compile(paramCommand.getRegexPattern());
		final Matcher matcher = pattern.matcher(params);
		
		if (!matcher.matches()) {
			Message.print("The following pattern wasn't idenfitied:\n" + matcher.toString());
			return;
		}
		
		if (ParamCommand.COUNT_ALL.equals(paramCommand)) {
			final long numberTotal = controller.countAll();
			Message.print(String.valueOf(numberTotal));
			return;
		}
		
		if (ParamCommand.COUNT_DISTINCT.equals(paramCommand)) {
		    final String propertyName = controller.getProperty(matcher.group(1));
		    
		    if (propertyName == null) {
		    	Message.printError("This property does not exist!");
		    	return;
		    }
		    
		    final long totalByDistinctProperty = controller.countDistinctBy(propertyName);
		    Message.print(String.valueOf(totalByDistinctProperty));
		    return;
		}
		
		if (ParamCommand.FILTER.equals(paramCommand)) {
			final String propertyName = controller.getProperty(matcher.group(1));
			final String propertyValue = matcher.group(2);
			
			if (propertyName == null) {
				Message.printError("This property does not exist!");
				return;
			}
			
			final String cleanedValue = propertyValue.replaceAll(Message.PATTERN_REGEX_BRACKETS, "");
			final String result = controller.filterBy(propertyName, cleanedValue);
			Message.print(result);
			return;
		}
		
		Message.printError("Invalid params!");
	}
	
}
