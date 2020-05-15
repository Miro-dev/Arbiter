package com.miros.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.miros.entities.attributes.AccessLevel;
import com.miros.entities.attributes.Specialty;

@Entity
@Table(name = "engineers")
public class Engineer {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String password;
	private String comment;

	@ManyToOne
	@JoinColumn(name = "id")
	private AccessLevel accessLevel;

//	@ManyToMany(mappedBy = "engineers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Order> orders = new HashSet<>();

	@ManyToMany(mappedBy = "engineers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Specialty> specialties = new HashSet<>();

	public Engineer() {
	}

	public Engineer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Engineer(String name) {
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

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
