package com.miros.jpa.repositories.attributes;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.miros.entities.attributes.Specialty;

public class SpecialtiesRepository {
	private EntityManager entityManager;

	public SpecialtiesRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<Specialty> save(Specialty specialty) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(specialty);
			entityManager.getTransaction().commit();
			return Optional.of(specialty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public Optional<Specialty> findById(Integer id) {
		Specialty specialty = entityManager.find(Specialty.class, id);
		return specialty != null ? Optional.of(specialty) : Optional.empty();
	}

//	public List<Specialty> findAll() {
//		return entityManager.createQuery("from Specialty").getResultList();
//	}

	public void deleteById(Integer id) {
		// Retrieve the movie with this ID
		Specialty specialty = entityManager.find(Specialty.class, id);
		if (specialty != null) {
			try {
				// Start a transaction because we're going to change the database
				entityManager.getTransaction().begin();

//				// Remove all references to this superhero in its movies
//				specialty.getEngineers().forEach(movie -> {
//					movie.getSpecialties().remove(specialty);
//				});

				// Now remove the superhero
				entityManager.remove(specialty);

				// Commit the transaction
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
