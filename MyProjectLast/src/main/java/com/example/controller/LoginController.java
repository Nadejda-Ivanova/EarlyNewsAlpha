package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.example.model.InvalidDAOException;
import com.example.model.User;
import com.example.model.UserDAO;
@SessionAttributes("loggeduser")
@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String logMe(Model model){
		model.addAttribute("user", new User());
		return "login2";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String writeCategory(@ModelAttribute User user, HttpServletRequest request){
		UserDAO dao = new UserDAO();
		try {
			User currentUser = dao.authenticate(user);
//			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ   "+ currentUser);
			request.getSession().setAttribute("loggeduser", currentUser);
		} catch (InvalidDAOException e) {
			request.setAttribute("errorMessage", "Invalid user name or password");
			return "login2";
		}
		System.out.println(user);
		return "adminHome";
	}
		
}
