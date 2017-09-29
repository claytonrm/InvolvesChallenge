package br.com.involves.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.involves.controller.Controller;
import br.com.involves.enums.ParamCommand;
import br.com.involves.util.Constants;
import br.com.involves.util.Message;

public class FilterByPropertyValue implements ActionStrategy {
	
	private static final Pattern PATTERN_FILTER = Pattern.compile(ParamCommand.FILTER.getRegexPattern());
	private Controller controller;
	private String params;
	
	public FilterByPropertyValue(final Controller controller, final String params) {
		this.controller = controller;
		this.params = params;
	}

	@Override
	public void execute() {
		final Matcher matcher = PATTERN_FILTER.matcher(params);
		if (!matcher.matches()) {
			Message.print("The following pattern wasn't idenfitied:\n" + matcher.toString());
			return;
		}
		
		final String propertyName = controller.getProperty(matcher.group(1));
		final String propertyValue = matcher.group(2);
		
		if (propertyName == null || propertyValue == null) {
			Message.printError("This property does not exist!");
			return;
		}
		
		final String cleanedValue = propertyValue.replaceAll(Constants.PATTERN_REGEX_BRACKETS, "");
		final String result = controller.filterBy(propertyName, cleanedValue);
		Message.print(result);
	}

}
