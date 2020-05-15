package com.miros.entities.attributes;

import com.miros.entities.Engineer;
import com.miros.entities.Manager;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-15T18:39:59.823+0200")
@StaticMetamodel(AccessLevel.class)
public class AccessLevel_ {
	public static volatile SingularAttribute<AccessLevel, Integer> id;
	public static volatile SingularAttribute<AccessLevel, String> name;
	public static volatile SetAttribute<AccessLevel, Engineer> engineers;
	public static volatile ListAttribute<AccessLevel, Manager> managers;
}
