package com.miros.jpa.repositories.attributes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miros.entities.attributes.AccessLevel;

@Repository
public class AccessLevelRepository {
	@Autowired
	EntityManagerFactory emf;

	private EntityManager entityManager;

	public AccessLevelRepository() {
	}

	public String save(AccessLevel accessLevel) {
		entityManager = emf.createEntityManager();
		// Check if engineer with this name exists
		String accessLevelName = accessLevel.getName();
		Optional<AccessLevel> check = findByName(accessLevelName);
		if (check.isPresent() == false) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(accessLevel);
				entityManager.getTransaction().commit();
				return "AccessLevel with name: " + accessLevelName + " was Created!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Could not make transaction!";
			}
		} else {
			return "AccessLevel with name: " + accessLevelName + " does already Exists!";
		}
	}

	public Optional<AccessLevel> findByName(String name) {
		entityManager = emf.createEntityManager();
		List<AccessLevel> result = entityManager.createNamedQuery("AccessLevel.findByName", AccessLevel.class)
				.setParameter("name", name).getResultList();
		return result.isEmpty() == false ? Optional.of(result.get(0)) : Optional.empty();
	}

	public String deleteByName(String accessLevelToDeleteName) {
		entityManager = emf.createEntityManager();
		// Check if accessLevel with this name exists
		Optional<AccessLevel> accessLevelToDelete = findByName(accessLevelToDeleteName);
		if (accessLevelToDelete.isPresent() == true) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(accessLevelToDelete.get());
				entityManager.getTransaction().commit();

				return "Employee with name: " + accessLevelToDeleteName + " was deleted!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Could not make transaction!";
			}
		} else {
			return "Employee with name: " + accessLevelToDeleteName + " does not exist!";
		}
	}
}

//accessLevel.getEngineers().forEach(engineer -> {
//	engineer.setAccessLevel(findByName("Undefined").get());
//	engineerRepository.save(engineer);
//});
