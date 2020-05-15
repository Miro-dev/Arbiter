package com.miros.entities;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.miros.entities.attributes.AccessLevel;
import com.miros.entities.attributes.StatusEngineer;

@MappedSuperclass
public abstract class EmployeeAbstract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Managers")
	private int ID;

	private String name;

	@Enumerated
	private AccessLevel accessLevel;

	@Enumerated
	private StatusEngineer status;

	private String comment;

	private String password;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
