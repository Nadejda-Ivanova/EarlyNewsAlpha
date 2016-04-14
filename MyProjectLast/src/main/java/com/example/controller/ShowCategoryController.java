package com.example.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.Comment;
import com.example.model.CommentDAO;
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;
@SessionAttributes("Article")
@Controller
public class ShowCategoryController {
	

		@RequestMapping(value="/category", method=RequestMethod.GET)
		public String createArt( @RequestParam("category")int category,Model model,HttpServletRequest request){
			model.addAttribute("Article", new Article());
			CategoryDAO dao = new CategoryDAO();
			ArrayList<Category> catList = null;
			try {
				catList = dao.getAllCategories();
			} catch (InvalidDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CommentDAO artdao=new CommentDAO();
			
			ArrayList<Comment> artList = null;
		
			try {				
				artList = (ArrayList<Comment>) artdao.getAllCommentsByArticleId(category);
				 
			} catch (InvalidDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//		request.getSession().setAttribute("categories", dao.getAllCategories());
			System.out.println("transfered to CreateA");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("artList",artList);
			
			session.setAttribute("catList",catList);
			//model.addAttribute("artList", artList);
			return "ShowComment";
		}
		
		

		
	}

