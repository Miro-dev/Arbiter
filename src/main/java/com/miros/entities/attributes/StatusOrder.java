package com.miros.entities.attributes;

public enum StatusOrder {
	QUEUED("Q"), WAITING_MATERIALS("W_M"), WAITING_ENGINEER("W_E"), IN_PROGRESS("I_P"), DONE("D");

	private String code;

	private StatusOrder(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
