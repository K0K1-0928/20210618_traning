package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@GetMapping
	public ModelAndView test(ModelAndView mav) {
		mav.setViewName("test");
		mav.addObject("msg", "message!");
		return mav;
	}

	@PostMapping
	public ModelAndView calc(@RequestParam("calc")String calc, ModelAndView mav) {
		OgnlContext ctx = new OgnlContext();
		Object expr;
		Object value;
		try {
			expr = Ognl.parseExpression(calc.replace("Math\\.", "@Math@"));
			value = Ognl.getValue(expr, ctx);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "Result!");
		mav.addObject("result", value);
		return mav;
	}
}
