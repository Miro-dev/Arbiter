package com.miros.controllers;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.EntityManagerFactoryDAO;
import com.miros.entities.Engineer;
import com.miros.entities.Manager;
import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.EngineerRepository;
import com.miros.jpa.repositories.attributes.AccessLevelRepository;

@Controller
public class CreateEmployeeController {

	@Autowired
	EntityManagerFactoryDAO emf;

	@RequestMapping(value = "/accountManagement/createManager", method = RequestMethod.POST)
	public ModelAndView CreateManager(@Valid @ModelAttribute("manager") Manager manager) {

		ModelAndView mv = new ModelAndView();
		EntityManager em = emf.getEntityManager();
		em.getTransaction().begin();
		em.persist(manager);
		em.getTransaction().commit();

		System.out.println("Mang: " + manager.getName() + " " + manager.getPassword() + " " + manager.getAccessLevel());

		return mv;
	}

	@RequestMapping(value = "/accountManagement/createEngineer", method = RequestMethod.POST)
	public ModelAndView CreateEngineer(@Valid @ModelAttribute("engineer") Engineer engineer) {

		ModelAndView mv = new ModelAndView();
		EntityManager em = emf.getEntityManager();
		EngineerRepository er = new EngineerRepository(em);
		AccessLevelRepository alr = new AccessLevelRepository(em);

		if (er.findByName(engineer.getName()).isPresent() == false) {
			AccessLevel accessLevel = alr.findByName("Engineer").get(); // Fix to show all accessLevels
			accessLevel.addEngineers(engineer);
			engineer.setAccessLevel(accessLevel);
			er.save(engineer);
			mv.addObject("responseFromDB_EmployeeCreation", "Engineer with name: " + engineer.getName() + " Created!");
		} else {
			mv.addObject("responseFromDB_EmployeeCreation", "Engineer with name: " + engineer.getName() + " Exists!");
		}
		mv.setViewName("accountManagement");
		return mv;
	}

	@RequestMapping(value = "/accountManagement/createAccessLevel", method = RequestMethod.POST)
	public ModelAndView CreateAccessLevel(@Valid @ModelAttribute("accessLevel") AccessLevel accessLevel) {
		EntityManager em = emf.getEntityManager();
		AccessLevelRepository alr = new AccessLevelRepository(em);
		ModelAndView mv = new ModelAndView();

		if (alr.findByName(accessLevel.getName()).isPresent() == false) {
			alr.save(accessLevel);
			mv.addObject("responseFromDB_AccessLevel",
					"Access Level with name: " + accessLevel.getName() + " created!");
		} else {
			mv.addObject("responseFromDB_AccessLevel", "Access Level Already Exists!");
		}

		mv.setViewName("accountManagement");
		return mv;
	}

	@RequestMapping(value = "/accountManagement/deleteAccessLevel", method = RequestMethod.POST)
	public ModelAndView DeleteAccessLevel(@RequestParam("deleteAccessLevel") String accessLevelName) {

		System.out.println(accessLevelName);
		EntityManager em = emf.getEntityManager();
		AccessLevelRepository alr = new AccessLevelRepository(em);
		EngineerRepository er = new EngineerRepository(em);
		ModelAndView mv = new ModelAndView();
		Optional<AccessLevel> accessLevelToDelete = alr.findByName(accessLevelName);

		if (accessLevelToDelete.isPresent() == true) {
			alr.deleteByName(accessLevelToDelete.get(), er);
			mv.addObject("responseFromDB_AccessLevel_Deletion",
					"Access Level with name: " + accessLevelName + " Deleted!");
		} else {
			mv.addObject("responseFromDB_AccessLevel_Deletion", "Access Level does not Exist!");
		}

		mv.setViewName("accountManagement");
		return mv;
	}
}
