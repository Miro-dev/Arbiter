package com.miros.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.miros.entities.attributes.Materials;
import com.miros.entities.attributes.ShipStyle;
import com.miros.entities.attributes.StatusOrder;

@Entity
public class Order {

	@Id
	@GeneratedValue

	private int ID;

	private String name;
	private String origin;
	@Enumerated
	private ShipStyle shipStyle;
	private Timestamp timeStamp;
	private Timestamp dueDate;
	@Enumerated
	private Materials materials;
	private String completionTime; // Change to hour:minute format
	private int price;
	@Enumerated
	private StatusOrder status;
	private int importance;
	@ManyToOne
	private Engineer isWorkedBy;
	@ManyToOne
	private Engineer isQueuedBy;
	@OneToMany
	private List<Materials> isWaitingFor;

	public Order(String name, String origin, ShipStyle shipStyle, Timestamp timeStamp, Timestamp dueDate) {
		super();
		this.name = name;
		this.origin = origin;
		this.shipStyle = shipStyle;
		this.timeStamp = timeStamp;
		this.dueDate = dueDate;
	}

	public Order() {
		System.out.println("Order Created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public ShipStyle getShipStyle() {
		return shipStyle;
	}

	public void setShipStyle(ShipStyle shipStyle) {
		this.shipStyle = shipStyle;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Materials getMaterials() {
		return materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public StatusOrder getStatus() {
		return status;
	}

	public void setStatus(StatusOrder status) {
		this.status = status;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public Engineer getIsWorkedBy() {
		return isWorkedBy;
	}

	public void setIsWorkedBy(Engineer isWorkedBy) {
		this.isWorkedBy = isWorkedBy;
	}

	public Engineer getIsQueuedBy() {
		return isQueuedBy;
	}

	public void setIsQueuedBy(Engineer isQueuedBy) {
		this.isQueuedBy = isQueuedBy;
	}

	public List<Materials> getIsWaitingFor() {
		return isWaitingFor;
	}

	public void setIsWaitingFor(List<Materials> isWaitingFor) {
		this.isWaitingFor = isWaitingFor;
	}

}
