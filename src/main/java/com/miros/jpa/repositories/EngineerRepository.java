package com.miros.jpa.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miros.entities.Engineer;
import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.attributes.AccessLevelRepository;

@Repository
public class EngineerRepository {

	@Autowired
	private EntityManagerFactory emf;

	@Autowired
	private AccessLevelRepository accessLevelRepository;

	private EntityManager entityManager;

	public EngineerRepository() {
		System.out.println("EngRepo Created!");
		System.out.println(emf);
	}

	public String save(Engineer engineer) {
		entityManager = emf.createEntityManager();
		System.out.println(entityManager);

		// Check if engineer with this name exists
		String engineerName = engineer.getName();
		Optional<Engineer> check = findByName(engineerName);
		if (check.isPresent() == false) {
			try {
				AccessLevel accessLevel = accessLevelRepository.findByName("Engineer").get();
				engineer.setAccessLevel(accessLevel);
				entityManager.getTransaction().begin();
				entityManager.persist(engineer);
				entityManager.getTransaction().commit();
				return "Employee with name: " + engineerName + " was Created!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Could not make transaction!";
			}
		} else {
			return "Employee with name: " + engineerName + " does already Exists!";
		}
	}

	public Optional<Engineer> findByName(String name) {
		List<Engineer> result = entityManager.createNamedQuery("Engineer.findByName", Engineer.class)
				.setParameter("name", name).getResultList();
		return result.isEmpty() == false ? Optional.of(result.get(0)) : Optional.empty();
	}

	public String deleteByName(String nameToDelete) {

		// Check if engineer with this name exists
		Optional<Engineer> employeeToDelete = findByName(nameToDelete);
		if (employeeToDelete.isPresent() == true) {
			try {

				entityManager.getTransaction().begin();
				entityManager.remove(employeeToDelete.get());
				entityManager.getTransaction().commit();

				return "Employee with name: " + nameToDelete + " was deleted!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Could not make transaction!";
			}
		} else {
			return "Employee with name: " + nameToDelete + " does not exist!";
		}
	}
}
