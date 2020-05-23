package com.miros.jpa.repositories.attributes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.EngineerRepository;

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
			System.out.println("AC created!");
			return Optional.of(accessLevel);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("AC Error on creation");
		}
		System.out.println("AC not created");
		return Optional.empty();
	}

	public Optional<AccessLevel> findById(Integer id) {
		AccessLevel accessLevel = entityManager.find(AccessLevel.class, id);
		return accessLevel != null ? Optional.of(accessLevel) : Optional.empty();
	}

	public Optional<AccessLevel> findByName(String name) {
		List<AccessLevel> result = entityManager.createNamedQuery("AccessLevel.findByName", AccessLevel.class)
				.setParameter("name", name).getResultList();
		return result.isEmpty() == false ? Optional.of(result.get(0)) : Optional.empty();
	}

	public void deleteByName(AccessLevel accessLevel, EngineerRepository engineerRepository) {
		try {
			// Start a transaction because we're going to change the database
			entityManager.getTransaction().begin();

			// Remove all references to this accessLevel in its engineers
			accessLevel.getEngineers().forEach(engineer -> {
				System.out.println("In deleteByName AL");
				engineer.setAccessLevel(findByName("Undefined").get());
				System.out.println("In deleteByName AL 2");
				engineerRepository.save(engineer);
				System.out.println("In deleteByName AL 3");
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

//	public Optional<AccessLevel> findByName(String name) {
//		AccessLevel accessLevel = entityManager.createNamedQuery("AccessLevel.findByName", AccessLevel.class)
//				.setParameter("name", name).getSingleResult();
//		System.out.println("In findByname");
//		return accessLevel != null ? Optional.of(accessLevel) : Optional.empty();
//	}

//	public List<AccessLevel> findAll() {
//		return entityManager.createQuery("from AccessLevel").getResultList();
//	}

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
