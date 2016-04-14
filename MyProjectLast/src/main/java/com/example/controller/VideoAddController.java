package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.model.Article;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;
import com.example.model.Video;
import com.example.model.VideoDAO;

@Controller
public class VideoAddController {

	private static final String THUMBNAIL_PART_TWO = "/1.jpg";
	private static final String THUMBNAIL_PART_ONE = "http://img.youtube.com/vi/";
	// private static final String IFRAME_PART_TWO = "' frameborder='0'
	// allowfullscreen></iframe>";
	// private static final String IFRAME_PART_ONE = "<iframe width='560'
	// height='315' src='https://www.youtube.com/embed/";

	@RequestMapping(value = "/addVideo", method = RequestMethod.GET)
	public String videoForm(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("loggeduser") != null) {
			CategoryDAO dao = new CategoryDAO();
			ArrayList<Category> catList = null;
			try {
				catList = dao.getAllCategories();
			} catch (InvalidDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.addAttribute("video", new Video());
			return "addVideo";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/addVideo", method = RequestMethod.POST)
	public String addVideo(@ModelAttribute("video") Video video, HttpServletRequest request) {
		String[] temp = video.getName().split("=");
		String videoId = temp[1].substring(0,11);
		System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR " + videoId);
		String thumbnail = THUMBNAIL_PART_ONE + videoId + THUMBNAIL_PART_TWO;
		// String embedLink = IFRAME_PART_ONE+ videoId+ IFRAME_PART_TWO;
		// Image videoImage = new Image();
		// videoImage.setName(thumbnail);
		// videoImage.setThumbnail(true);
		Article currentArticle = (Article) request.getSession().getAttribute("newArticle");

		video.setiBelongTo(currentArticle);
		video.setName(videoId);
		// video.setDateAdded(LocalDateTime.now());
		video.setPath(thumbnail);
		// videoImage.setArtId(currentArticle.getId());
		// ImageDAO picDAO = new ImageDAO();
		// int videoImgId =0;
		// try {
		// videoImgId = picDAO.addImage(videoImage);
		// } catch (InvalidDAOException e) {
		// e.printStackTrace();
		//// request.setAttribute("error", "Saving Video to Database has failed
		// try again");
		// return "redirect:/admin/addVideo";
		//
		// }
		// videoImage.setId(videoImgId);
		Video currentVideo = new Video();
		currentVideo.setName(videoId);
		currentVideo.setiBelongTo(currentArticle);
		currentVideo.setPath(thumbnail);

		// currentVideo.setImage(videoImage);
		VideoDAO videoDAO = new VideoDAO();
		try {
			videoDAO.addVideo(currentVideo);
			// currentVideo
			// videoDAO.addVideo(setPath(thumbnail););
		} catch (InvalidDAOException e) {
			e.printStackTrace();
			// request.setAttribute("error", "Saving Video to Database has
			// failed try again");
			return "redirect:/addVideo";
		}
		return "videoSuccess";

	}
}
