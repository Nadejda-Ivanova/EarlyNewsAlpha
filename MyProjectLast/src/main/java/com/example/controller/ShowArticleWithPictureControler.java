package com.example.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@SessionAttributes("Article3")
@Controller
public class ShowArticleWithPictureControler {
	
	


		@RequestMapping(value="/article3", method=RequestMethod.GET)
		public String createArt( @RequestParam("artID")int artID,	Model model,HttpServletRequest request){
			model.addAttribute("Article3", new Article());
			CategoryDAO dao = new CategoryDAO();
			ArrayList<Category> catList = null;
			try {
				catList = dao.getAllCategories();
			} catch (InvalidDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArticleDAO artdao=new ArticleDAO();
			ImageDAO imagedao=new ImageDAO();
			CommentDAO coment=new CommentDAO();
		    List<Comment> coments= null;
			Article article = null;
			Image image =null;
			try {
				coments=coment.getAllCommentsByArticleId(artID);
			} catch (InvalidDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				article = artdao.getArticleById(artID);
			} catch (InvalidDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				image = imagedao.getImageById(artID);
			} catch (InvalidDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("currentArticle11", article);
			session.setAttribute("article",article);
			session.setAttribute("image",image);
			session.setAttribute("coments", coments);
			session.setAttribute("catList",catList);
			return "test2";
		}
		
		
		

		
	}

