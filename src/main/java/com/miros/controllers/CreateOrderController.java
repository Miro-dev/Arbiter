package com.miros.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.EntityManagerFactoryDAO;

@Controller
public class CreateOrderController {

	@Autowired
	EntityManagerFactoryDAO emf;

	@RequestMapping(value = "createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder() throws Exception {

		EntityManager em = emf.getEntityManager();

		ModelAndView mv = new ModelAndView();

//		EngTest eng = new EngTest(0, "Sayman", AccessLevel.ENGINEER, Specialty.ADMINISTRATIVE, );

		em.getTransaction().begin();
//		em.persist(eng);
		em.getTransaction().commit();

		mv.setViewName("created");

		return mv;

	}

}