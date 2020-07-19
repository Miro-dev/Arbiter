package com.miros.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EngineerPanel {

    @RequestMapping(value = "/engineer/engineerPanel")
    public ModelAndView engineerPanel() throws Exception {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("engineerPanel");

        return mv;
    }

}
