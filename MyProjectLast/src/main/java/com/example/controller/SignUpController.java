package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.InvalidDAOException;
import com.example.model.User;
import com.example.model.UserDAO;

@Controller
public class SignUpController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signMe(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loggeduser") != null) {
			model.addAttribute("user", new User());
			return "signUp";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signMeUp(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		UserDAO dao = new UserDAO();
		try {
			String userName = user.getName();
			String password = user.getPassword();
			if (userName == null || userName.isEmpty() || userName.length() < 5) {
				request.setAttribute("errorMessage", "User name not valid");
				return "signUp";
			}
			if (password == null || password.isEmpty() || password.length() < 8) {
				request.setAttribute("errorMessage", "Password not valid");
				return "signUp";
			}
			dao.createUser(user);

		} catch (Exception e) {
			e.printStackTrace();
			return "/errorPage";
		}

		System.out.println(user);
		return "login";
	}
}
