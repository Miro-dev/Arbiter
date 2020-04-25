package com.miros.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.OrderDAO;
import com.miros.web.Materials;
import com.miros.web.StaticHelpers;

@Controller
public class AddController {

	@Autowired
	private StaticHelpers staticHelpers;
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();

		int num1 = Integer.parseInt(req.getParameter("t1"));
		int num2 = Integer.parseInt(req.getParameter("t2"));
		int k = num1 + num2;

		List<Materials> list = new ArrayList<Materials>();
		list.add(Materials.CERAMICS);
		list.add(Materials.ELECTRONICS);
		list.add(Materials.METAL);

		Timestamp ts = staticHelpers.getTimestamp();

		mv.addObject("result", k);
		mv.addObject("list", list);
		mv.addObject("timestamp", ts);
		mv.setViewName("result");

		return mv;
	}
}
