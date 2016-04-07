package com.example.controller;

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
	
	@RequestMapping(value="/admin/AddCategory", method=RequestMethod.GET)
	public String addCategory(Model model){
		model.addAttribute("newCategory", new Category());
		return "addcategory";
	}

	@RequestMapping(value="/admin/AddCategory", method=RequestMethod.POST)
	public String writeCategory(@ModelAttribute Category newCategory) throws InvalidDAOException{
		CategoryDAO dao = new CategoryDAO();
		dao.addCategory(newCategory);
		System.out.println(newCategory);
		return "categorySuccess";
	}
	
}
