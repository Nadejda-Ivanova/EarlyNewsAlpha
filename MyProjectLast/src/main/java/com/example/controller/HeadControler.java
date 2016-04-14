package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;

@SessionAttributes("newCateory")
@Controller
public class HeadControler {
	@RequestMapping(value="/head", method=RequestMethod.GET)
	public String addNewArticle(@ModelAttribute Category newCategory, Model model,HttpServletRequest request) throws InvalidDAOException {
	
	
	CategoryDAO dao = new CategoryDAO();
	ArrayList<Category> catList = null;
	try {
		catList = dao.getAllCategories();
		
		
	} catch (InvalidDAOException e) {
		// TUKA DA PREPRATJA KUM DRUGA STRANICA ZA FAILURE SEGA OTIVA NA upload.jsp
		e.printStackTrace();
	}
	
	System.out.println("ARTICLE WAS ADDED, CHECK DB?");
	HttpSession session = request.getSession(true);
	session.setAttribute("catList",catList);
	
		return "wetyuio";
	}
}
