package util;

public class Message {
	
	public static void printOptions() {
		print("=================== Welcome!===================\nType \"count *\" to count all the records\n"
				+ "Type \"count distinct [property]\" to count that distinct properties\n"
				+ "Type \"filter [property] [value]\" to find a record.\n"
				+ "==========================================");
	}
	
	public static void invalidParam() {
		System.err.println("Invalid param!");
	}
	
	public static void print(final String message) {
		System.out.println(message);
		
	}
	public static final String CSV_SEPARATOR = ","; 
	
}
