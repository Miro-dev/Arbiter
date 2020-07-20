package com.miros.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.miros.entities.attributes.AccessLevel;

@Entity
@Table(name = "engineer")
@NamedQuery(name = "Engineer.findByName", query = "FROM Engineer WHERE name = :name")
public class Engineer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_engineers;
	private String name;
	private String password;
	private String comment;
	private String roles;
	private Boolean active;

//	@ManyToOne
//	@JoinColumn(name = "access_level_id")
//	private AccessLevel accessLevel;

//	@ManyToMany(mappedBy = "engineers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Order> orders = new HashSet<>();

//	@ManyToMany(mappedBy = "engineers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Specialty> specialties = new HashSet<>();


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Engineer() {
	}

	public Engineer(Integer id, String name) {
		this.id_engineers = id;
		this.name = name;
	}

	public Engineer(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id_engineers;
	}

	public void setId(Integer id) {
		this.id_engineers = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	public AccessLevel getAccessLevel() {
//		return accessLevel;
//	}
//
//	public void setAccessLevel(AccessLevel accessLevel) {
//		this.accessLevel = accessLevel;
//	}

}
