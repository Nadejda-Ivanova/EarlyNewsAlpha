package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Article;
import com.example.model.Category;
import com.example.model.Comment;
import com.example.model.CommentDAO;
import com.example.model.InvalidDAOException;

@Controller
public class AddCommentsController {

	@RequestMapping(value = "/AddComment", method = RequestMethod.GET)
	public String addCategory(Model model, HttpServletRequest request) {
			model.addAttribute("newComment", new Comment());
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			return "addcomment";
		
	}
	@RequestMapping(value = "/AddComment", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Comment comment, HttpServletRequest request) throws InvalidDAOException {
//		Article tempArticle = (Article)request.getSession().getAttribute("newComment");
		Article article = (Article)request.getSession().getAttribute("currentArticle11");
		comment.setArticle(article);
		CommentDAO daoComment = new CommentDAO();
		daoComment.createComment(comment);
			return "../";
		
	}
	
}
