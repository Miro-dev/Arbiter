package com.miros.entities;

import com.miros.entities.attributes.AccessLevel;
import com.miros.entities.attributes.Specialty;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-15T15:56:04.780+0200")
@StaticMetamodel(Engineer.class)
public class Engineer_ {
	public static volatile SingularAttribute<Engineer, Integer> id;
	public static volatile SingularAttribute<Engineer, String> name;
	public static volatile SingularAttribute<Engineer, AccessLevel> accessLevel;
	public static volatile SetAttribute<Engineer, Specialty> specialties;
	public static volatile SingularAttribute<Engineer, String> password;
	public static volatile SingularAttribute<Engineer, String> comment;
}
