package com.miros.entities.attributes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.miros.entities.Engineer;

@Entity
@Table(name = "access_level")
@NamedQuery(name = "AccessLevel.findByName", query = "FROM AccessLevel WHERE name = :name")
public class AccessLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

//	@OneToMany(mappedBy = "accessLevel")
//	private List<Manager> managers = new ArrayList<>();

	@OneToMany(mappedBy = "accessLevel", cascade = CascadeType.PERSIST)
	private List<Engineer> engineers = new ArrayList<>();

	// Make for Manager

	public AccessLevel() {
	}

	public AccessLevel(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Engineer> getEngineers() {
		System.out.println("Returns Eng list!");
		return engineers;
	}

	public void addEngineers(Engineer engineer) {
		System.out.println("Adds to Eng list!");
		engineers.add(engineer);
		engineer.setAccessLevel(this);
	}

}
