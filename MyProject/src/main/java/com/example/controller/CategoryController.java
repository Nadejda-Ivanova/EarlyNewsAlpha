package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Category;
import com.example.model.CategoryDAO;

@Controller
public class CategoryController {
	
	@RequestMapping(value="/AddCategory", method=RequestMethod.GET)
	public String addCategory(ModelMap model){
		model.addAttribute("newCategory", new Category());
		return "addcategory";
	}

	@RequestMapping(value="/AddCategory", method=RequestMethod.POST)
	public String writeCategory(@ModelAttribute Category newCategory){
		CategoryDAO dao = new CategoryDAO();
		dao.addCategory(newCategory);
		System.out.println(newCategory);
		return "categorySuccess";
	}
	
}
