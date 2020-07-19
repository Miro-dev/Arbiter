package com.miros.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {

	@PostMapping(value = "/admin/adminPanel")
	public ModelAndView createOrder() throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("managerPanel");

		return mv;
	}

}
