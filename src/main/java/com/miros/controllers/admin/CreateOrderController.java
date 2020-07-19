package com.miros.controllers.admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateOrderController {

	@Autowired
	EntityManagerFactory emf;

	@RequestMapping(value = "createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder() throws Exception {
		EntityManager em = emf.createEntityManager();

		ModelAndView mv = new ModelAndView();

//		EngTest eng = new EngTest(0, "Sayman", AccessLevel.ENGINEER, Specialty.ADMINISTRATIVE, );

		em.getTransaction().begin();
//		em.persist(eng);
		em.getTransaction().commit();

		mv.setViewName("created");

		return mv;

	}

}