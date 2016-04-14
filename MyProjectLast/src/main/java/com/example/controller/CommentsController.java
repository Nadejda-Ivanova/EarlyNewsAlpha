package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.model.Comment;
import com.example.model.CommentDAO;
//import com.example.model.CommentReview;
import com.example.model.InvalidDAOException;

@Controller
public class CommentsController {

	@RequestMapping(value = "/CommentsReview", method = RequestMethod.GET)
	public String showBadCommets(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loggeduser") != null) {
			CommentDAO daoCom = new CommentDAO();
			model.addAttribute("review", new Comment());
			Comment temp = null;
			try {
				temp = daoCom.getFirstBad();
				// System.out.println(temp.getId()+"zzzzzzzzzzzzzzzzzzzzz");
				if (temp == null) {
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
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/CommentsReview", method = RequestMethod.POST)
	public String deleteBadComments(@ModelAttribute("review") Comment currentComment) {
		// System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"
		// + currentComment.isToBeDeleted());
		// System.out.println(currentComment.getIdBad());
		CommentDAO daoCom = new CommentDAO();
		if (currentComment.isToBeDeleted()) {
			try {
				daoCom.deleteCommentById(currentComment.getId());

			} catch (InvalidDAOException e) {
				e.printStackTrace();

				return "commentsReview";
			}
		}

		return "redirect:/mainPage";

	}

}
