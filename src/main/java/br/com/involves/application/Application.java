package br.com.involves.application;

import java.util.Scanner;

import br.com.involves.util.Message;

public class Application {
	
	private DataSetAssistant dataSetAssistant;
	
	public void run() {
		dataSetAssistant = new DataSetAssistant("files/cidades.csv");
		
		try (final Scanner scanner = new Scanner(System.in)) {
			Message.printOptions();
			while (scanner.hasNextLine()) {
				final String params = scanner.nextLine();
				dataSetAssistant.assist(params);
				Message.printOptions();
			}
		};
	}

}
