package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Katerica;

@Controller
public class KatericaController {
	
	@RequestMapping(value="/katerici", method=RequestMethod.GET)
	public String printKatPage(Model model){
		model.addAttribute("katerica", new Katerica());
		return "katerica";
	}
	
	@RequestMapping(value="/katerici", method=RequestMethod.POST)
	public String addKaterica(@ModelAttribute Katerica katerica, HttpServletRequest request){
	System.out.println("Dobavih katerica " + katerica.getName());
	request.setAttribute("message", "Success!");
	return "katerica";}
	
	
}
