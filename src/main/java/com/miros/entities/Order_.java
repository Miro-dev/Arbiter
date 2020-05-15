package com.miros.entities;

import com.miros.entities.attributes.Materials;
import com.miros.entities.attributes.ShipStyle;
import com.miros.entities.attributes.StatusOrder;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-15T13:34:55.624+0200")
@StaticMetamodel(Order.class)
public class Order_ {
	public static volatile SingularAttribute<Order, Integer> ID;
	public static volatile SingularAttribute<Order, String> name;
	public static volatile SingularAttribute<Order, String> origin;
	public static volatile SingularAttribute<Order, ShipStyle> shipStyle;
	public static volatile SingularAttribute<Order, Timestamp> timeStamp;
	public static volatile SingularAttribute<Order, Timestamp> dueDate;
	public static volatile SingularAttribute<Order, Materials> materials;
	public static volatile SingularAttribute<Order, String> completionTime;
	public static volatile SingularAttribute<Order, Integer> price;
	public static volatile SingularAttribute<Order, StatusOrder> status;
	public static volatile SingularAttribute<Order, Integer> importance;
	public static volatile SingularAttribute<Order, Engineer> isWorkedBy;
	public static volatile SingularAttribute<Order, Engineer> isQueuedBy;
	public static volatile ListAttribute<Order, Materials> isWaitingFor;
}
