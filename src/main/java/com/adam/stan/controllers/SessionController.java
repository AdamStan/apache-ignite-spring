package com.adam.stan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sessions")
public class SessionController {
// TODO: methods: get mapping to html websites for add and remove
    @GetMapping("/new")
    public ModelAndView addAttributesForm() {
        return new ModelAndView("/sessions/session-create.html");
    }
    
    @GetMapping("/remove")
    public ModelAndView removeAttributesForm() {
        return new ModelAndView("/sessions/session-remove.html");
    }
}
