
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController  {

	@RequestMapping(value="/logout")
	public String showErrorPage(){
		
		return "logout";
			
	}
	
}