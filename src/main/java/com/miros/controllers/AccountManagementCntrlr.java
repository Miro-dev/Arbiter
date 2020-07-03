package com.miros.controllers;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miros.entities.Engineer;
import com.miros.entities.Manager;
import com.miros.entities.attributes.AccessLevel;
import com.miros.web.CreationForm;

@Controller
@ControllerAdvice
public class AccountManagementCntrlr {

	@Autowired
	private EntityManagerFactory emf;

	@RequestMapping(value = "/admin/accountManagement")
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

	@ModelAttribute("accessLevel")
	public AccessLevel getAccessLevel() {
		return new AccessLevel();
	}

}
