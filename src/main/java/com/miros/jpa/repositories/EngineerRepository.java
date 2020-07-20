package com.miros.jpa.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miros.entities.Engineer;
import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.attributes.AccessLevelRepository;
import org.springframework.stereotype.Service;

//@Service
//public interface EngineerRepository extends JpaRepository<Engineer, Integer> {
//    Optional<Engineer> findByUserName(String userName);
//}

@Repository
public class EngineerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private AccessLevelRepository accessLevelRepository;

	public EngineerRepository() {
		System.out.println("EngRepo Created!");
		System.out.println(entityManagerFactory);
	}

	public String save(Engineer engineer) {
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager);

		// Check if engineer with this name exists
		String engineerName = engineer.getName();
		Optional<Engineer> check = findByName(engineerName);
		if (!check.isPresent()) {
			try {
				AccessLevel accessLevel = accessLevelRepository.findByName("Engineer").get();
//				engineer.setAccessLevel(accessLevel);
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
		System.out.println("This is from repo Eng + " + entityManager);
		List<Engineer> result = entityManager.createNamedQuery("Engineer.findByName", Engineer.class)
				.setParameter("name", name).getResultList();
		System.out.println("This is from repo Eng: " + result.get(0));
		return Optional.of(result.get(0));
//		return result.isEmpty() == false ? Optional.of(result.get(0)) : Optional.empty();
	}

	public String deleteByName(String nameToDelete) {

		// Check if engineer with this name exists
		Optional<Engineer> employeeToDelete = findByName(nameToDelete);
		if (employeeToDelete.isPresent()) {
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
