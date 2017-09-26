package application;

import java.util.Scanner;

import util.Message;

public class Application {
	
	private DataSetAssistant dataSetAssistant;
	
	public void run() {
		dataSetAssistant = new DataSetAssistant("files/cidades.csv");
		
		try (final Scanner scanner = new Scanner(System.in)) {
			Message.printOptions();
			while (scanner.hasNextLine()) {
				final String[] params = scanner.nextLine().split("\\s");
				dataSetAssistant.assist(params);
				Message.printOptions();
			}
		};
	}

}
