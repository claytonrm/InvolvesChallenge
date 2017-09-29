package br.com.involves.strategy;

import br.com.involves.controller.Controller;
import br.com.involves.util.Message;

public class CountAllStrategy implements ActionStrategy {

	private final Controller controller;
	
	public CountAllStrategy(final Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		final long numberTotal = controller.countAll();
		Message.print(String.valueOf(numberTotal));
	}

}
