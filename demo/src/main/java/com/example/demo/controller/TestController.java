package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("/test")
	public ModelAndView test(ModelAndView mav) {
		mav.setViewName("test");
		mav.addObject("msg", "message!");
		return mav;
	}
}
