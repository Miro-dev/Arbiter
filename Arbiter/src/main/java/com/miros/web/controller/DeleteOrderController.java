package com.miros.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miros.DB.OrderDAO;

@Controller
public class DeleteOrderController {

	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value = "deleteOrder", method = RequestMethod.POST)
	public ModelAndView deleteOrder(HttpServletRequest req) throws Exception {

		ModelAndView mv = new ModelAndView();

		int orderID = Integer.parseInt(req.getParameter("destr"));

//		Timestamp ts = staticHelpers.getTimestamp(); this should be implemented somewhere

		orderDAO.deleteOrder(orderID);
		mv.setViewName("index");
		return mv;
	}
}
