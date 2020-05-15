package com.miros.entities.attributes;

public enum StatusEngineer {
	WORKING("Wo"), WAITING("Wa");

	private String code;

	private StatusEngineer(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
