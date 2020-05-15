package com.miros.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.EntityManagerFactoryDAO;

@Controller
public class ShowAllOrders {

	@Autowired
	EntityManagerFactoryDAO emf;

	@RequestMapping(value = "showOrders", method = RequestMethod.GET)
	public ModelAndView createOrder() throws Exception {

		EntityManager em = emf.getEntityManager();

		em.getTransaction().begin();
//		em.remove(eng);
		em.getTransaction().commit();

		ModelAndView mv = new ModelAndView();
//		Add what happens after the get
		// Do the same for Create, Get, Update
		mv.setViewName("index");

		return mv;
	}
}
