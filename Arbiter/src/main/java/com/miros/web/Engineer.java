package com.miros.web;

public class Engineer implements Employee {
	private String credentials;
	private AccessLevel accessLevel = AccessLevel.ENGINEER;
	private Specialty isCapable;
	private TableEngineers tableEngineers;
	private PermissionLevel permissionLevel;
	private StatusEngineer status;
	private String comment;

	public void setTime() {
		// Sets time for completion of order
	}

	public void setMaterilas() {
		// Sets materials for completion of order
	}

	public void setStatus() {
		// Sets ordersStatus for order
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Specialty getIsCapable() {
		return isCapable;
	}

	public void setIsCapable(Specialty isCapable) {
		this.isCapable = isCapable;
	}

	public TableEngineers getTableEngineers() {
		return tableEngineers;
	}

	public void setTableEngineers(TableEngineers tableEngineers) {
		this.tableEngineers = tableEngineers;
	}

	public PermissionLevel getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(PermissionLevel permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public StatusEngineer getStatus() {
		return status;
	}

	public void setStatus(StatusEngineer status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
