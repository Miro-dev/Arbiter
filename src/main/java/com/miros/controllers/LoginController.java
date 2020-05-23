package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// Fix for LoginController with database name and pass

// Order Management System "Arbiter"
// React, Spring, Hibernate, JPA, MVC

@Controller
public class LoginController {
	@GetMapping(value = { "/", "/login" })
	public ModelAndView loginModelAndView() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}
}
