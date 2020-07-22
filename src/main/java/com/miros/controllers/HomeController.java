package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView createOrder(HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("home");

        System.out.println(request.getRemoteUser());

        return mv;
    }

}
