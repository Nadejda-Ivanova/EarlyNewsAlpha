package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.example.model.InvalidDAOException;
import com.example.model.Subscribe;
import com.example.model.SubscribeDAO;

@SessionAttributes("error")
@Controller
public class SubscribeController {
	
	@RequestMapping(value="/subscribe", method=RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("subscribe", new Subscribe());
		return "subscribe";
	}
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String subscribeMe(@ModelAttribute Subscribe subscription, HttpServletRequest request){
		SubscribeDAO daoSubs = new SubscribeDAO();
		
		try {
			daoSubs.addSubscription(subscription);
		} catch (InvalidDAOException e) {
			e.printStackTrace();
			request.getSession().setAttribute("error", "database error, please try again");
			return "redirect:/subscribe";
		}
		request.getSession().setAttribute("error", "you have subscribed for our newsletter");
		return "redirect:/subscribe";
	}
}
