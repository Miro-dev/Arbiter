package com.miros.web;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-28T16:09:45.058+0200")
@StaticMetamodel(Engineer.class)
public class Engineer_ {
	public static volatile SingularAttribute<Engineer, Integer> ID;
	public static volatile SingularAttribute<Engineer, String> name;
	public static volatile SingularAttribute<Engineer, AccessLevel> accessLevel;
	public static volatile SingularAttribute<Engineer, StatusEngineer> status;
	public static volatile SingularAttribute<Engineer, String> comment;
	public static volatile SingularAttribute<Engineer, String> password;
}
