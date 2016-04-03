package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;
import com.example.model.User;
import com.example.model.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/AdminLogin", method=RequestMethod.GET)
	public String logMe(Model model){
		model.addAttribute("user", new User());
		return "login";
		
	}
	
	@RequestMapping(value="/AdminLogin", method=RequestMethod.POST)
	public String writeCategory(@ModelAttribute User user, HttpServletRequest request){
		UserDAO dao = new UserDAO();
		try {
			User currentUser = dao.authenticate(user);
			request.getSession().setAttribute("loggeduser", currentUser);
		} catch (InvalidDAOException e) {
			request.setAttribute("errorMessage", "Invalid user name or password");
			return "login";
		}
		System.out.println(user);
		return "adminHome";
	}
		
}
