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

@Controller
public class CategoryController {

	@RequestMapping(value = "/AddCategory", method = RequestMethod.GET)
	public String addCategory(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loggeduser") != null) {
			model.addAttribute("newCategory", new Category());
			return "addcategory";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public String writeCategory(@ModelAttribute Category newCategory) throws InvalidDAOException {
		CategoryDAO dao = new CategoryDAO();
		dao.addCategory(newCategory);
		System.out.println(newCategory);
		return "categorySuccess";
	}

}
