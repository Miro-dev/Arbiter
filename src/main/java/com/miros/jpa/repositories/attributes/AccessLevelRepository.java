package com.miros.jpa.repositories.attributes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.miros.entities.attributes.AccessLevel;

public class AccessLevelRepository {
	private EntityManager entityManager;

	public AccessLevelRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<AccessLevel> save(AccessLevel accessLevel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(accessLevel);
			entityManager.getTransaction().commit();
			return Optional.of(accessLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public Optional<AccessLevel> findById(Integer id) {
		AccessLevel accessLevel = entityManager.find(AccessLevel.class, id);
		return accessLevel != null ? Optional.of(accessLevel) : Optional.empty();
	}

	public List<AccessLevel> findAll() {
		return entityManager.createQuery("from AccessLevel").getResultList();
	}

	public void deleteById(Integer id) {
		// Retrieve the accessLevel with this ID
		AccessLevel accessLevel = entityManager.find(AccessLevel.class, id);
		if (accessLevel != null) {
			try {
				// Start a transaction because we're going to change the database
				entityManager.getTransaction().begin();

				// Remove all references to this accessLevel in its engineers
				accessLevel.getEngineers().forEach(engineer -> {
					engineer.setAccessLevel(new AccessLevel("Undefined AccessLevel"));
				});

//				// Remove all references to this accessLevel in its managers
//				accessLevel.getManagers().forEach(manager -> {
//					manager.setAccessLevel(new AccessLevel("Undefined AccessLevel"));
//				});

				// Now remove the accessLevel
				entityManager.remove(accessLevel);

				// Commit the transaction
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
