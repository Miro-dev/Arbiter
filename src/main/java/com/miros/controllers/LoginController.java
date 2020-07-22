package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Fix for LoginController with database name and pass

// Order Management System "Arbiter"
// React, Spring, Hibernate, JPA, MVC

@Controller
public class LoginController {

	@GetMapping(value = { "/login" })
	public ModelAndView login() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

	// Spring security will see this message.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView m = new ModelAndView();
		if (error != null) {
			m.addObject("error", "Invalid username and password error.");
		}

		if (logout != null) {
			m.addObject("msg", "You have left successfully.");
		}

		m.setViewName("login");
		return m;
	}
}
