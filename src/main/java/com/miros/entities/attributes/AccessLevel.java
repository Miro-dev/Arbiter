package com.miros.entities.attributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.miros.entities.Engineer;
import com.miros.entities.Manager;

@Entity
@Table(name = "access_levels")
public class AccessLevel {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "engineer_id", cascade = CascadeType.ALL)
	private List<Manager> managers = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "access_level_engineers", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "engineer_id") })
	private Set<Engineer> engineers = new HashSet<>();

	public AccessLevel() {
	}

	public AccessLevel(Integer id, String name) {
		this.id = id;
		this.name = name;
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

//	public Set<Manager> getManagers() {
//		return managers;
//	}
//
//	public void setManagers(Set<Manager> managers) {
//		this.managers = managers;
//	}

	public Set<Engineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(Set<Engineer> engineers) {
		this.engineers = engineers;
	}
}
