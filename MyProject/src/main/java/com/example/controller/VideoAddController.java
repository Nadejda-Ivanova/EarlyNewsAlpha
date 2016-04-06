package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Article;
import com.example.model.CommentReview;
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;
import com.example.model.Video;
import com.example.model.VideoDAO;

@Controller
public class VideoAddController {
	
	
	private static final String THUMBNAIL_PART_TWO = "/1.jpg";
	private static final String THUMBNAIL_PART_ONE = "http://img.youtube.com/vi/";
	private static final String IFRAME_PART_TWO = "' frameborder='0' allowfullscreen></iframe>";
	private static final String IFRAME_PART_ONE = "<iframe width='560' height='315' src='https://www.youtube.com/embed/";

	@RequestMapping(value="/addVideo", method=RequestMethod.GET)
	public String videoForm(Model model){
		model.addAttribute("video", new Video());
		return "addVideo";
		}

	
	
	@RequestMapping(value="/addVideo", method=RequestMethod.POST)
	public String addVideo(@ModelAttribute("video") Video video, HttpServletRequest request) {
		String[] temp = video.getName().split("=");
		String videoId = temp[temp.length-1];
		String thumbnail = THUMBNAIL_PART_ONE + videoId+THUMBNAIL_PART_TWO;
		String embedLink = IFRAME_PART_ONE+ videoId+ IFRAME_PART_TWO;
		Image videoImage = new Image();
		videoImage.setName(thumbnail);
		videoImage.setThumbnail(true);
		Article currentArticle = (Article) request.getSession().getAttribute("newArticle");
		videoImage.setArtId(currentArticle.getId());
		ImageDAO picDAO = new ImageDAO();
		int videoImgId =0;
		try {
			videoImgId = picDAO.addImage(videoImage);
		} catch (InvalidDAOException e) {
			e.printStackTrace();
//			model.addAttribute("error", "Saving Video to Database has failed try again");
			return "redirect:/addVideo";
			
		}
		videoImage.setId(videoImgId);
		Video currentVideo = new Video();
		currentVideo.setName(embedLink);
		currentVideo.setImage(videoImage);
		VideoDAO videoDAO = new VideoDAO();
		try {
			videoDAO.addVideo(currentVideo);
		} catch (InvalidDAOException e) {
			e.printStackTrace();
//			model.addAttribute("error", "Saving Video to Database has failed try again");
			return "redirect:/addVideo";
		}
		return "videoSuccess";
		
		
	}
}
