package br.com.involves.application;

import java.util.Scanner;

import br.com.involves.util.Constants;
import br.com.involves.util.Message;

public class Application {
	
	public void run() {
		try (final Scanner scanner = new Scanner(System.in)) {
			Message.printOptions();
			while (scanner.hasNextLine()) {
				final String params = scanner.nextLine();
				new DataSetAssistant(Constants.RESOURCE_DIR + "cidades.csv").assist(params);
				Message.printOptions();
			}
		};
	}

}
