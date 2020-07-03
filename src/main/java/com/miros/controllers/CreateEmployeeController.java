package com.miros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miros.entities.Engineer;
import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.EngineerRepository;
import com.miros.jpa.repositories.attributes.AccessLevelRepository;
import com.miros.security.EngineerDetailsService;

@Controller
public class CreateEmployeeController {

//	@RequestMapping(value = "/accountManagement/createManager", method = RequestMethod.POST)
//	public ModelAndView CreateManager(@Valid @ModelAttribute("manager") Manager manager) {
//
//		ModelAndView mv = new ModelAndView();
//
//		return mv;
//	}
	@Autowired
	EngineerRepository er;
	@Autowired
	AccessLevelRepository alr;

	@Autowired
	EngineerDetailsService eds;

	@RequestMapping(value = "/admin/accountManagement/createEngineer", method = RequestMethod.POST)
	public ModelAndView CreateEngineer(@Valid @ModelAttribute("engineer") Engineer engineer) {

		ModelAndView mv = new ModelAndView();

		mv.addObject("responseFromDB_EmployeeCreation", eds.registerNewUserAccount(engineer));
		mv.setViewName("accountManagement");
		// Fix URLs after you create Eng and than click to ManagerPanel
		return mv;
	}

	@RequestMapping(value = "/accountManagement/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView DeleteEmployee(@RequestParam("employeeName") String employeeName) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("responseFromDB_EmployeeCreation", er.deleteByName(employeeName));
		return mv;
	}

	@RequestMapping(value = "/accountManagement/createAccessLevel", method = RequestMethod.POST)
	public ModelAndView CreateAccessLevel(@Valid @ModelAttribute("accessLevel") AccessLevel accessLevel) {
		ModelAndView mv = new ModelAndView();
		AccessLevelRepository alr = new AccessLevelRepository();

		alr.save(accessLevel);

		mv.setViewName("accountManagement");
		return mv;
	}

	@RequestMapping(value = "/accountManagement/deleteAccessLevel", method = RequestMethod.POST)
	public ModelAndView DeleteAccessLevel(@RequestParam("deleteAccessLevel") String accessLevelName) {

		ModelAndView mv = new ModelAndView();
		AccessLevelRepository alr = new AccessLevelRepository();

		mv.addObject("responseFromDB_AccessLevel", alr.deleteByName(accessLevelName));
		mv.setViewName("accountManagement");
		return mv;
	}
}
