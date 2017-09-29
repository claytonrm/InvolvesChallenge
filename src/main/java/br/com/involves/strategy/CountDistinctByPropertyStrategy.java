package br.com.involves.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.involves.controller.Controller;
import br.com.involves.enums.ParamCommand;
import br.com.involves.util.Message;

public class CountDistinctByPropertyStrategy implements ActionStrategy {

	private static final Pattern PATTERN_COUNT_DISTINCT = Pattern.compile(ParamCommand.COUNT_DISTINCT.getRegexPattern());
	private Controller controller;
	private String params;

	public CountDistinctByPropertyStrategy(final Controller controller, final String params) {
		this.controller = controller;
		this.params = params;
	}

	@Override
	public void execute() {
		final Matcher matcher = PATTERN_COUNT_DISTINCT.matcher(params);
		
		if (!matcher.matches()) {
			Message.print("The following pattern wasn't idenfitied:\n" + matcher.toString());
			return;
		}
		
		final String property = controller.getProperty(matcher.group(1));

		if (property == null) {
			Message.printError("This property does not exist!");
			return;
		}

		final long totalByDistinctProperty = controller.countDistinctBy(property);
		Message.print(String.valueOf(totalByDistinctProperty));
	}

}
