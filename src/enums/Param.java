package enums;

import java.util.Arrays;

public enum Param {
	
	COUNT_ALL(new String[] {"count", "*"}), 
	COUNT_DISTINCT(new String[] {"count", "distinct"}), 
	FILTER(new String[] {"filter"});
	
	private String[] params;
	
	private Param(String[] params) {
		this.params = params;
	}

	public String[] getParams() {
		return params;
	}
	
	public static Param get(final String[] paramSequence) {
		final Param[] validParams = Param.values();

		for (Param param : validParams) {
			if (Arrays.equals(param.getParams(), paramSequence)) {
				return param;
			}
		}
		return null;
	}

}
