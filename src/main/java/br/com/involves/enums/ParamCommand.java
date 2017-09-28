package br.com.involves.enums;

import br.com.involves.util.Constants;

public enum ParamCommand {
	
	COUNT_ALL("count *", Constants.PATTERN_REGEX_COUNT_ALL, "In order to count all records."), 
	COUNT_DISTINCT("count distinct [property]", Constants.PATTERN_REGEX_COUNT_DISTINCT, "In order to count the distinct values of the property."), 
	FILTER("filter [property] [value]", Constants.PATTERN_REGEX_FILTER, "In order to filter a value by specific property.");
	
	private String commandSyntax;
	private String regexPattern;
	private String description;
	

	private ParamCommand(final String commandSyntax, final String regexPattern, final String description) {
		this.commandSyntax = commandSyntax;
		this.regexPattern = regexPattern;
		this.description = description;
	}

	public String getCommandSyntax() {
		return commandSyntax;
	}
	
	public String getRegexPattern() {
		return regexPattern;
	}

	public String getDescription() {
		return description;
	}

	public static ParamCommand get(final String paramSequence) {
		if (paramSequence != null) {
			final ParamCommand[] validParams = ParamCommand.values();
	
			for (ParamCommand param : validParams) {
				if (paramSequence.matches(param.getRegexPattern())) {
					return param;
				}
			}
		}
		return null;
	}

	public static String showAllCommandSyntax() {
		final StringBuilder output = new StringBuilder();
		for (ParamCommand param : ParamCommand.values()) {
			output.append("\"");
			output.append(param.getCommandSyntax());
			output.append("\" - ");
			output.append(param.getDescription());
			output.append("\n");
		}
		return output.toString();
	}
	
}
