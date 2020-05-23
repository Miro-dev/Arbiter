package com.miros.entities.attributes;

import com.miros.entities.Engineer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-16T10:09:35.836+0200")
@StaticMetamodel(Specialty.class)
public class Specialty_ {
	public static volatile SingularAttribute<Specialty, Integer> id;
	public static volatile SingularAttribute<Specialty, String> name;
	public static volatile SingularAttribute<Specialty, String> comment;
	public static volatile SetAttribute<Specialty, Engineer> engineers;
}
