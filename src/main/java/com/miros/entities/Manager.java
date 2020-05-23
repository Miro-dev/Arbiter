package com.miros.entities;

import com.miros.entities.attributes.AccessLevel;
import com.miros.entities.attributes.StatusEngineer;

//@Entity
//@Table(name = "managers")
public class Manager extends EmployeeAbstract {

	private int ID;

//	@Column(name = "name")
	private String name;

//	@Enumerated
	private AccessLevel accessLevel;

//	@Enumerated
	private StatusEngineer status;

	private String comment;

	private String password;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	@Override
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public StatusEngineer getStatus() {
		return status;
	}

	@Override
	public void setStatus(StatusEngineer status) {
		this.status = status;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}
}
