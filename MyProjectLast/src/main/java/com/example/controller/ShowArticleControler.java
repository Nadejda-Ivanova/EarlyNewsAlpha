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
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;
@SessionAttributes("Article")
@Controller
public class ShowArticleControler {
	
	


		@RequestMapping(value="/article", method=RequestMethod.GET)
		public String createArt( @RequestParam("category")String category,Model model,HttpServletRequest request){
			model.addAttribute("Article", new Article());
			CategoryDAO dao = new CategoryDAO();
			ArrayList<Category> catList = null;
			try {
				catList = dao.getAllCategories();
			} catch (InvalidDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArticleDAO artdao=new ArticleDAO();
			ImageDAO imgdao=new ImageDAO();
			ArrayList<Article> artList = null;
		ArrayList<Image> imgList=new ArrayList<Image>();
			try {				
				artList = (ArrayList<Article>) artdao.getAllArticlesByCategoryName(category);
				 for(Article article:artList){
					 imgList.add(imgdao.getImageById(article.getId()));
				 }
			} catch (InvalidDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//		request.getSession().setAttribute("categories", dao.getAllCategories());
			System.out.println("transfered to CreateA");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("artList",artList);
			session.setAttribute("imgList", imgList);
			session.setAttribute("category", category);
			session.setAttribute("catList",catList);
			//model.addAttribute("artList", artList);
			return "ShowArticleN";
		}
		
		
		

		
	}

