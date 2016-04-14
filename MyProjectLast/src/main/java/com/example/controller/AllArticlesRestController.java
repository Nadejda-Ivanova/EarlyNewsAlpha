package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.InvalidDAOException;

@RestController
public class AllArticlesRestController {
	ArticleDAO art = new ArticleDAO();
	
	@RequestMapping (value ="/services/allarticles")
	public List<Article> getAllArticles (HttpSession httpSession) throws InvalidDAOException{
		List <Article> list = new ArrayList<Article>();
		list= art.getAllArticles();
		return list;
	}

	
	
}
