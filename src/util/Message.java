package util;

public class Message {
	
	private Message() {
		new AssertionError("This class must not be instantiate!");
	}
	
	public static final String CSV_SEPARATOR = ","; 
	public static final String HEADER = "header";
	public static final String CONTENT = "content";
	public static final String PATTERN_REGEX_BETWEEN_BRACKETS = "\\[.+\\]";
	public static final String PATTERN_REGEX_BRACKETS = "[\\[\\]]";
	public static final String NEW_LINE = "\n";
	public static final String HORIZONTAL_SEPARATOR = "-------------------------------------------------------------------------------------------\n";
	
	public static void printOptions() {
		print("\n============================== Welcome! =================================\nType \"count *\" to count all the records\n"
				+ "Type \"count distinct [property]\" to count that distinct properties\n"
				+ "Type \"filter [property] [value]\" to find a record\n"
				+ "=========================================================================");
	}
	
	public static void print(final String message) {
		System.out.println(message);
	}
	
	public static void printError(final String message) {
		System.err.println(message);
	}
	
}
