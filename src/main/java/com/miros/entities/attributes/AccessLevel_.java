package com.miros.entities.attributes;

import com.miros.entities.Engineer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-22T17:27:07.093+0200")
@StaticMetamodel(AccessLevel.class)
public class AccessLevel_ {
	public static volatile SingularAttribute<AccessLevel, Integer> id;
	public static volatile ListAttribute<AccessLevel, Engineer> engineers;
	public static volatile SingularAttribute<AccessLevel, String> name;
}
