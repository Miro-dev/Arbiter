package com.miros.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.miros.entities.attributes.AccessLevel;
import com.miros.entities.attributes.StatusEngineer;

@Entity
@Table(name = "managers")
public class Manager extends EmployeeAbstract {

	private int ID;

	@Column(name = "name")
	private String name;

	@Enumerated
	private AccessLevel accessLevel;

	@Enumerated
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

}
