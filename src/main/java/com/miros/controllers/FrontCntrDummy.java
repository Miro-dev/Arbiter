package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

// Fix for LoginController with database name and pass

@Controller
public class FrontCntrDummy {

	{
		System.out.println("FrontCntr");
	}

	public ModelAndView loginModelAndView() throws Exception {

		{
			System.out.println(2);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}
}