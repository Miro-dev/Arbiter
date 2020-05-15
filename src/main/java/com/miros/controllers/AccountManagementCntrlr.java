package com.miros.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miros.entities.Engineer;
import com.miros.entities.Manager;
import com.miros.web.CreationForm;

@Controller
@ControllerAdvice
public class AccountManagementCntrlr {

	@RequestMapping(value = "/accountManagement")
	public String AccountManagement(@Valid @ModelAttribute("creationForm") CreationForm creationForm,
			BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}

		return "accountManagement";
	}

	@ModelAttribute("manager")
	public Manager getManager() {
		return new Manager();
	}

	@ModelAttribute("engineer")
	public Engineer getEngineer() {
		return new Engineer();
	}

}
