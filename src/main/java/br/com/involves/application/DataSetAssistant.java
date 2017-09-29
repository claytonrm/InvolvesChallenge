package br.com.involves.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import br.com.involves.controller.CityController;
import br.com.involves.controller.Controller;
import br.com.involves.enums.ParamCommand;
import br.com.involves.strategy.ActionStrategy;
import br.com.involves.strategy.Context;
import br.com.involves.strategy.CountAllStrategy;
import br.com.involves.strategy.CountDistinctByPropertyStrategy;
import br.com.involves.strategy.FilterByPropertyValue;
import br.com.involves.util.Constants;
import br.com.involves.util.Message;

public class DataSetAssistant {

	private final Controller controller = new CityController();
	private Map<ParamCommand, ActionStrategy> contexts = new HashMap<>();
	private Path path;
	
	public DataSetAssistant(final String fileName) {
		path = Paths.get(fileName);
		controller.loadCsv(path.toAbsolutePath().toString(), Constants.CSV_SEPARATOR);
	}

	private void initializeContextActions(final String params) {
		contexts.put(ParamCommand.COUNT_ALL, new CountAllStrategy(controller));
		contexts.put(ParamCommand.COUNT_DISTINCT, new CountDistinctByPropertyStrategy(controller, params));
		contexts.put(ParamCommand.FILTER, new FilterByPropertyValue(controller, params));
	}

	private void executeParams(final ParamCommand paramCommand, final String params) {
		final ActionStrategy action = contexts.get(paramCommand);
		final Context actionContext = new Context(action);
		
		actionContext.execute();
	}

	public void assist(final String params) {
		final ParamCommand commandParam = ParamCommand.get(params);
		
		if (commandParam == null) {
			Message.printError("Invalid parameters! The expected commands are:\n" + ParamCommand.showAllCommandSyntax());
			return;
		}
		
		initializeContextActions(params);
		executeParams(commandParam, params);
	}
	
}
