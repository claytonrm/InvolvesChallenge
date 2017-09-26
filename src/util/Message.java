package util;

public class Message {
	
	public static void printOptions() {
		System.out.println("=================== Welcome!===================\nType \"count *\" to count all the records\n"
				+ "Type \"count distinct [property]\" to count that distinct properties\n"
				+ "Type \"filter [property] [value]\" to find a record.\n"
				+ "==========================================");
	}
	
}
