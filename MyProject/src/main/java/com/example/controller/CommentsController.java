package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Article;
import com.example.model.Category;
import com.example.model.Comment;
import com.example.model.CommentDAO;
import com.example.model.CommentReview;
import com.example.model.InvalidDAOException;



@Controller
public class CommentsController {

	@RequestMapping(value="/CommentsReview", method=RequestMethod.GET)
	public String showBadCommets(Model model){
		CommentDAO daoCom = new CommentDAO();
		model.addAttribute("review", new Comment());
		Comment temp;
		try {
			temp = daoCom.getFirstBad();
			if(temp != null){
				model.addAttribute("error", "No bad comments reported");
				return "commentsReview";
			}
		} catch (InvalidDAOException e1) {
			model.addAttribute("error", "No bad comments reported");
			return "commentsReview";
		}
		try {
			daoCom.setCommentAsOK(temp.getId());
		} catch (InvalidDAOException e) {
			e.printStackTrace();
		}
		model.addAttribute("comment", temp);
		
		return "commentsReview";
		
	}
	
	@RequestMapping(value="/CommentsReview", method=RequestMethod.POST)
	public String deleteBadComments(@ModelAttribute("review") Comment currentComment) {
//		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//		System.out.println(currentComment.getIdBad());
		CommentDAO daoCom = new CommentDAO();
		try {
			daoCom.deleteCommentById(Integer.parseInt(currentComment.getIdBad()));
			
		} catch (InvalidDAOException e) {
			e.printStackTrace();

			return "commentsReview";
		}
		
		return "redirect:/mainPage";

	}
	
}
