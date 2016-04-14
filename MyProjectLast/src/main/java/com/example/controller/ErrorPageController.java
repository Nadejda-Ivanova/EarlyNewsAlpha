
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController  {

	@RequestMapping(value="/errorPage")
	public String showErrorPage(){
		// mojesh eventualno da vzemesh message ot exceptiona
		return "errorPage";
			
	}
	
}
