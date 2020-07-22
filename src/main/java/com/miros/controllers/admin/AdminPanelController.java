package com.miros.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {

	@RequestMapping(value = "/apanel")
	public ModelAndView createOrder() throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("managerPanel");

		return mv;
	}

}
