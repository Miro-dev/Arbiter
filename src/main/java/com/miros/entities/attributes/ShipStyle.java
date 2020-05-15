package com.miros.entities.attributes;

public enum ShipStyle {
	ARGOS("A"), DREADNOUGHT("D"), MORPHEUS("M");

	private String code;

	private ShipStyle(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
