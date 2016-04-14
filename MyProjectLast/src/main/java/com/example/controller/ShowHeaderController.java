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
public class ShowHeaderController {

	@RequestMapping(value="/orka", method=RequestMethod.GET)
	public String createArt( Model model,HttpServletRequest request){
	model.addAttribute("Article", new Article());
	CategoryDAO dao = new CategoryDAO();
	String cat1="",cat2="",cat3="";
	ArrayList<Article> catList1 = null;
	ArrayList<Article> catList2 = null;
	ArrayList<Article> catList3 = null;
	
	ArticleDAO artdao=new ArticleDAO();
	ImageDAO imgdao=new ImageDAO();
	
	CategoryDAO dao1 = new CategoryDAO();
	ArrayList<Category> catList = null;
	try {
		catList = dao1.getAllCategories();
	} catch (InvalidDAOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
ArrayList<Image> imgList1=new ArrayList<Image>();
ArrayList<Image> imgList2=new ArrayList<Image>();
ArrayList<Image> imgList3=new ArrayList<Image>();
	try {				
		cat1 = dao.getCategoryNameById(1);
		catList1 = (ArrayList<Article>) artdao.getAllArticlesByCategoryName(cat1);
		 for(Article article:catList1){
			 imgList1.add(imgdao.getImageById(article.getId()));
		 }
	} catch (InvalidDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {				
		cat2 = dao.getCategoryNameById(2);
		catList1 = (ArrayList<Article>) artdao.getAllArticlesByCategoryName(cat2);
		 for(Article article:catList1){
			 imgList1.add(imgdao.getImageById(article.getId()));
		 }
	} catch (InvalidDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {				
		cat3 = dao.getCategoryNameById(3);
		catList1 = (ArrayList<Article>) artdao.getAllArticlesByCategoryName(cat3);
		 for(Article article:catList1){
			 imgList1.add(imgdao.getImageById(article.getId()));
		 }
	} catch (InvalidDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//		request.getSession().setAttribute("categories", dao.getAllCategories());
	System.out.println("transfered to CreateA");
	
	HttpSession session = request.getSession(true);
	session.setAttribute("artList1",catList1);
	session.setAttribute("artList2",catList2);
	session.setAttribute("artList3",catList3);
	session.setAttribute("imgList1", imgList1);
	session.setAttribute("imgList2", imgList2);
	session.setAttribute("imgList3", imgList3);
	session.setAttribute("category1", cat1);
	session.setAttribute("category2", cat2);
	session.setAttribute("category3", cat3);
	session.setAttribute("catList",catList);
	//model.addAttribute("artList", artList);
	return "index";
}
}
