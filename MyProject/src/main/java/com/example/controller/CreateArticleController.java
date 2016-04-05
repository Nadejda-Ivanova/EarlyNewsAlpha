package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;

@SessionAttributes("newArticle")
@Controller
public class CreateArticleController {

	@RequestMapping(value="/newarticle", method=RequestMethod.GET)
	public String createArt(Model model){
		model.addAttribute("newArticle", new Article());
		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category> catList  = dao.getAllCategories();
		//		request.getSession().setAttribute("categories", dao.getAllCategories());
		System.out.println("transfered to CreateA");
		model.addAttribute("catList", catList);
		return "CreateA";
	}
	
	@RequestMapping(value="/newarticle", method=RequestMethod.POST)
	public String addNewArticle(@ModelAttribute Article newArticle, Model model) {
	newArticle.setDateAdded(LocalDateTime.now());
	newArticle.setDateModified(LocalDateTime.now());
	CategoryDAO daoCat = new CategoryDAO();
	int idCat = Integer.parseInt(newArticle.getCatId());
	Category temporary = daoCat.getCategoryById(idCat);
	newArticle.setCategory(temporary);
	ArticleDAO daoArt = new ArticleDAO();
	int articleIDfromDB =0;
	
	try {
		articleIDfromDB = daoArt.createArticle(newArticle);
		newArticle.setId(articleIDfromDB);
		model.addAttribute("newArticle", newArticle);
	} catch (InvalidDAOException e) {
		// TUKA DA PREPRATJA KUM DRUGA STRANICA ZA FAILURE SEGA OTIVA NA upload.jsp
		e.printStackTrace();
	}
	
	System.out.println("ARTICLE WAS ADDED, CHECK DB?");
//	Pishe v dao i vzima idto DA SMENJA NULATA
//	ArticleDAO dao= new ArticleDAO();
//	dao.createArticle(article)
//	int number =0;
//	request.getSession().setAttribute("id", number);
//	System.out.println(newArticle);
		return "/addVideo";
	}
	
//	@RequestMapping(value="/newarticle", method=RequestMethod.PUT)
//	public String addPictures(@ModelAttribute Article newArticle) {
//	System.out.println(newArticle);
//		return "upload";
//	}
	
}
