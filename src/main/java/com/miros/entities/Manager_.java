package com.miros.entities;

import com.miros.entities.attributes.StatusEngineer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-15T13:34:55.561+0200")
@StaticMetamodel(Manager.class)
public class Manager_ extends EmployeeAbstract_ {
	public static volatile SingularAttribute<Manager, Integer> ID;
	public static volatile SingularAttribute<Manager, String> name;
	public static volatile SingularAttribute<Manager, StatusEngineer> status;
	public static volatile SingularAttribute<Manager, String> comment;
	public static volatile SingularAttribute<Manager, String> password;
}
