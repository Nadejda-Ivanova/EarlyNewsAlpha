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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;
@SessionAttributes("Article1")
@Controller

public class ShowPicture {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String ShowImg(Model model,HttpServletRequest request){
		model.addAttribute("Article1", new Image());
		
		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category> catList = null;
		try {
			catList = dao.getAllCategories();
		} catch (InvalidDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageDAO img=new ImageDAO();
		ArrayList<Image> imgList = null;
		try {
			imgList = (ArrayList<Image>) img.getAllImagesByArticleId(1);
			
			//System.out.println("------"+imgList.get(0).getPath());
		} catch (InvalidDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		request.getSession().setAttribute("categories", dao.getAllCategories());
		
		HttpSession session = request.getSession(true);
		session.setAttribute("imgList",imgList);
		session.setAttribute("catList",catList);

		//model.addAttribute("artList", artList);
		return "test3";
	}
	
}
