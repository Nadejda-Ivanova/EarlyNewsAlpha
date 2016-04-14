
package com.example.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
@SessionAttributes("Article3")
@Controller
public class showArt {
	@RequestMapping(value="/article2", method=RequestMethod.GET)
	public String createArt(Model model,HttpServletRequest request){
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
		ImageDAO img=new ImageDAO();
		Map<Article,ArrayList<Image> > art =null;
		ArrayList<Article> artList = null;
		ArrayList<Image> imgList = null;
		int i=0;
		try {
			artList = (ArrayList<Article>) artdao.getAllArticlesByCategoryName("tok");
			 for(Article article:artList){
					imgList = (ArrayList<Image>) img.getAllImagesByArticleId(5);
				art.put(article,imgList );
				i++;
			 }
		} catch (InvalidDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		request.getSession().setAttribute("categories", dao.getAllCategories());
		System.out.println("transfered to CreateA");
		HttpSession session = request.getSession(true);
		session.setAttribute("art",art);
		session.setAttribute("catList",catList);
		//model.addAttribute("artList", artList);
		return "test4";
	}
	
	
	

	
}
