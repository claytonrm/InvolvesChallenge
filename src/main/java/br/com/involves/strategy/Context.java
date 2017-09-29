package br.com.involves.strategy;

public class Context {

	private ActionStrategy action;
	
	public Context(final ActionStrategy action) {
		this.action = action;
	}
	
	public void execute() {
		action.execute();
	}
}
