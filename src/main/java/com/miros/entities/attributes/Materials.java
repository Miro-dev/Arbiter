package com.miros.entities.attributes;

public enum Materials {
	METAL("M"), PLASTIC("P"), CERAMICS("C"), TEXTILE("T"), ORGANIC("O"), ELECTRONICS("E");

	private String code;

	private Materials(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
