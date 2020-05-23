package com.miros.entities;

import com.miros.entities.attributes.AccessLevel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-16T16:08:06.771+0200")
@StaticMetamodel(Engineer.class)
public class Engineer_ {
	public static volatile SingularAttribute<Engineer, Integer> id;
	public static volatile SingularAttribute<Engineer, String> name;
	public static volatile SingularAttribute<Engineer, String> password;
	public static volatile SingularAttribute<Engineer, String> comment;
	public static volatile SingularAttribute<Engineer, AccessLevel> accessLevel;
}
