package com.miros.web;

import java.sql.Timestamp;
import java.util.List;

public class Order {

	private String name;
	private String origin;
	private ShipStyle shipStyle;
	private List<Procedure> procedures;
	private Timestamp timeStamp;
	private Timestamp dueDate;
	private Materials materials;
	private String completionTime; // Change to hour:minute format
	private int price;
	private StatusOrder status;
	private int importance;
	private Engineer isWorkedBy;
	private Engineer isQueuedBy;
	private List<Materials> isWaitingFor;

	public Order(String name, String origin, ShipStyle shipStyle, List<Procedure> procedures, Timestamp timeStamp,
			Timestamp dueDate) {
		super();
		this.name = name;
		this.origin = origin;
		this.shipStyle = shipStyle;
		this.procedures = procedures;
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

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
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
