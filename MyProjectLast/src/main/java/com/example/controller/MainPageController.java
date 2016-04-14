package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;

@Controller
public class MainPageController {

	@RequestMapping(value = "/mainPage")
	public ModelAndView showMain(HttpServletRequest request) {
		ModelAndView mv1 = new ModelAndView("login");
		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category> catList = null;
		try {
			catList = dao.getAllCategories();
		} catch (InvalidDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (request.getSession().getAttribute("loggeduser") != null) {
			ModelAndView mv = new ModelAndView("adminHome");

			return mv;
		} else {
			return mv1;
		}

	}

}
