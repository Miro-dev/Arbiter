package com.miros.controllers;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miros.DB.EntityManagerFactoryDAO;
import com.miros.entities.Engineer;
import com.miros.entities.Manager;

@Controller
public class CreateManagerController {

	@Autowired
	EntityManagerFactoryDAO emf;

//	@Autowired
//	Manager managerBean;
//
//	@Autowired
//	Engineer engineerBean;

	@RequestMapping(value = "/createManager", method = RequestMethod.POST)
	public String CreateManager(@Valid @ModelAttribute("manager") Manager manager) {

		EntityManager em = emf.getEntityManager();

//		em.persist(manager);

		em.getTransaction().begin();
		em.persist(manager);
		em.getTransaction().commit();

		System.out.println("Mang: " + manager.getName() + " " + manager.getPassword() + " " + manager.getAccessLevel());

		return "accountManagement";
	}

	@RequestMapping(value = "/createEngineer", method = RequestMethod.POST)
	public String CreateEngineer(@Valid @ModelAttribute("engineer") Engineer engineer) {

		EntityManager em = emf.getEntityManager();

		System.out
				.println("Eng: " + engineer.getName() + " " + engineer.getPassword() + " " + engineer.getAccessLevel());

		em.persist(engineer);

		return "accountManagement";
	}
}
