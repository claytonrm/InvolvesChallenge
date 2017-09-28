package br.com.involves.enums;

public enum ParamCommand {
	
	COUNT_ALL("count *", "count\\s+\\*\\s*$", "In order to count all records."), 
	COUNT_DISTINCT("count distinct [property]", "count\\s+distinct\\s+(\\[.+\\])\\s*$", "In order to count the distinct values of the property."), 
	FILTER("filter [property] [value]", "filter\\s+(\\[.+\\])\\s+(\\[.+\\])\\s*$", "In order to filter a value by specific property.");
	
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
