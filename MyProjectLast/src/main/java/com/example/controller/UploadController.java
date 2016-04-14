package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UploadController {

	@RequestMapping(value = "/uploadcontroller", method = RequestMethod.GET)
	public String getUploadForm(HttpServletRequest request) {
		if (request.getSession().getAttribute("loggeduser") != null) {
			return "uplodform";
		} else {
			return "redirect:/login";
		}
	}

}
