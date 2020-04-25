package com.miros.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.OrderDAO;
import com.miros.web.Order;
import com.miros.web.Procedure;
import com.miros.web.ShipStyle;
import com.miros.web.StaticHelpers;

@Controller
public class CreateOrderController {

	@Autowired
	private StaticHelpers staticHelpers;
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value = "createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder(HttpServletRequest req) throws Exception {

		ModelAndView mv = new ModelAndView();

		List<Procedure> procedures = new ArrayList<Procedure>();
		procedures.add(Procedure.ELECTRONICS);
		procedures.add(Procedure.CONSTRUCTION);

		Timestamp ts = staticHelpers.getTimestamp();

		Order o1 = new Order("Yamakato", "Sosuma Inc", ShipStyle.DREADNOUGHT, procedures, ts, ts);

		orderDAO.constructOrder(o1);

		mv.setViewName("created");

		return mv;
	}

}
