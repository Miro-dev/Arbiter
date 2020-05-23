package com.miros.entities;

import com.miros.entities.attributes.StatusEngineer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-16T11:34:03.920+0200")
@StaticMetamodel(EmployeeAbstract.class)
public class EmployeeAbstract_ {
	public static volatile SingularAttribute<EmployeeAbstract, Integer> id;
	public static volatile SingularAttribute<EmployeeAbstract, String> name;
	public static volatile SingularAttribute<EmployeeAbstract, StatusEngineer> status;
	public static volatile SingularAttribute<EmployeeAbstract, String> comment;
	public static volatile SingularAttribute<EmployeeAbstract, String> password;
}
