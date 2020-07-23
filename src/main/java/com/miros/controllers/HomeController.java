package com.miros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("react")
@CrossOrigin("*")
public class HomeController {

    @GetMapping
    public String createOrder()  {
//    public ModelAndView createOrder(HttpServletRequest request) throws Exception {

//        ModelAndView mv = new ModelAndView();
//
//        mv.setViewName("home");
//
//        System.out.println(request.getRemoteUser());
//
//        return mv;

        return "Hello from Java!";
    }

}
