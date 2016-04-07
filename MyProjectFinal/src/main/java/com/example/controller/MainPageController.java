package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

	@RequestMapping(value="/admin/mainPage")
	public ModelAndView showMain(){
		ModelAndView mv = new ModelAndView("adminHome");
		return mv;
			
	}
	
}
