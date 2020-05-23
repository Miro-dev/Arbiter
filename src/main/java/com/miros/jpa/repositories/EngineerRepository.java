package com.miros.jpa.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.miros.entities.Engineer;

public class EngineerRepository {
	private EntityManager entityManager;

	public EngineerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<Engineer> save(Engineer engineer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(engineer);
			entityManager.getTransaction().commit();
			System.out.println("ENG created!");
			return Optional.of(engineer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ENG err!");
		}
		System.out.println("ENG err 2!");
		return Optional.empty();
	}

	public Optional<Engineer> findById(Integer id) {
		Engineer engineer = entityManager.find(Engineer.class, id);
		return engineer != null ? Optional.of(engineer) : Optional.empty();
	}

	public Optional<Engineer> findByName(String name) {
		List<Engineer> result = entityManager.createNamedQuery("Engineer.findByName", Engineer.class)
				.setParameter("name", name).getResultList();
		return result.isEmpty() == false ? Optional.of(result.get(0)) : Optional.empty();
	}

//	public List<Engineer> findAll() {
//		return entityManager.createQuery("from Engineer").getResultList();
//	}

	public void deleteById(Integer id) {
		// Retrieve the engineer with this ID
		Engineer engineer = entityManager.find(Engineer.class, id);
		if (engineer != null) {
			try {
				// Start a transaction because we're going to change the database
				entityManager.getTransaction().begin();

				// Remove all references to this engineer by AccessLevel
//				engineer.getAccessLevel().getEngineers().remove(engineer);

//				// Remove all references to this engineer by Orders
//				engineer.getOrders().forEach(order -> {
//					order.getEngineers().remove(engineer);
//				});

//				// Remove all references to this engineer by Specialties
//				engineer.getSpecialties().forEach(specialty -> {
//					specialty.getEngineers().remove(engineer);
//				});

				// Now remove the engineer
				entityManager.remove(engineer);

				// Commit the transaction
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
