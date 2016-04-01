package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.CategoryDAO;


@Controller
public class CreateArticleController {

	@RequestMapping(value="/newarticle", method=RequestMethod.GET)
	public String createArt(Model model){
		model.addAttribute("newArticle", new Article());
		CategoryDAO dao = new CategoryDAO();
		ArrayList<String> temp =new ArrayList<String>();
		ArrayList<Article> artList  = new ArrayList<Article>();
		for(int i =0; i<artList.size(); i++){
			temp.add(artList.get(i).getCategory().getName());
		}
//		request.getSession().setAttribute("categories", dao.getAllCategories());
		System.out.println("transfered to CreateA");
		model.addAttribute("catList", temp);
		return "CreateA";
	}
	
	@RequestMapping(value="/newarticle", method=RequestMethod.POST)
	public String addNewArticle(@ModelAttribute Article newArticle) {
	newArticle.setDateAdded(LocalDateTime.now());
	newArticle.setDateModified(LocalDateTime.now());
	System.out.println(newArticle);
//	Pishe v dao i vzima idto DA SMENJA NULATA
//	ArticleDAO dao= new ArticleDAO();
//	dao.createArticle(article)
//	int number =0;
//	request.getSession().setAttribute("id", number);
//	System.out.println(newArticle);
		return "upload";
	}
	
//	@RequestMapping(value="/newarticle", method=RequestMethod.PUT)
//	public String addPictures(@ModelAttribute Article newArticle) {
//	System.out.println(newArticle);
//		return "upload";
//	}
	
}
