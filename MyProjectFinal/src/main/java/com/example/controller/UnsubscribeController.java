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
@SessionAttributes("success")
@Controller
public class UnsubscribeController {

		@RequestMapping(value="/unsubscribe", method=RequestMethod.GET)
		public String showForm(Model model){
			model.addAttribute("unsubscribe", new Subscribe());
			return "unsubscribe";
		}
		
		@RequestMapping(value="/unsubscribe", method=RequestMethod.POST)
		public String subscribeMe(@ModelAttribute Subscribe subscription, HttpServletRequest request){
			SubscribeDAO daoSubs = new SubscribeDAO();
			
			try {
				daoSubs.deleteSubscriptionByEmail(subscription.getEmail());
			} catch (InvalidDAOException e) {
				e.printStackTrace();
				request.getSession().setAttribute("success", "database error, please try again");
				return "redirect:/unsubscribe";
			}
			request.getSession().setAttribute("success", "you have unsubscribed from our newsletter");
			return "redirect:/unsubscribe";
		}
	}
	
