package br.com.involves.enums;

public enum ParamCommand {
	
	COUNT_ALL("count *", "count\\s+\\*\\s*$", "In order to count all records."), 
	COUNT_DISTINCT("count distinct [property]", "count\\s+distinct\\s+(\\[.+\\])\\s*$", "In order to count the distinct values of the property."), 
	FILTER("filter [property] [value]", "filter\\s+(\\[.+\\])\\s+(\\[.+\\])\\s*$", "In order to filter a value by specific property.");
	
	private String commandSintax;
	private String regexPattern;
	private String description;
	

	private ParamCommand(final String commandSintax, final String regexPattern, final String description) {
		this.commandSintax = commandSintax;
		this.regexPattern = regexPattern;
		this.description = description;
	}

	public String getCommandSintax() {
		return commandSintax;
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

	public static String showAllCommandSintax() {
		final StringBuilder output = new StringBuilder();
		for (ParamCommand param : ParamCommand.values()) {
			output.append("\"");
			output.append(param.getCommandSintax());
			output.append("\" - ");
			output.append(param.getDescription());
			output.append("\n");
		}
		return output.toString();
	}
	
}
