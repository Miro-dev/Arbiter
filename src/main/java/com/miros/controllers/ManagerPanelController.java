package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerPanelController {

	@PostMapping(value = "managerPanel")
	public ModelAndView createOrder() throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("managerPanel");

		return mv;
	}

}
