package com.miros.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistence");
	EntityManager em;

	public EntityManagerFactoryDAO() {
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
