package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.CommentReview;
import com.example.model.Video;

@Controller
public class VideoAddController {
	
	
	@RequestMapping(value="/addVideo", method=RequestMethod.GET)
	public String videoForm(Model model){
		model.addAttribute("video", new Video());
		return "addVideo";
		}
	
	@RequestMapping(value="/addVideo", method=RequestMethod.POST)
	public ModelAndView addVideo(@ModelAttribute Video video) {
		System.out.println(video.getName());
		ModelAndView model1 = new ModelAndView("videoSuccess");
		String[] temp = video.getName().split("=");
		String videoId = temp[temp.length-1];
//		Insert in DB and 
		
		return model1;
		
		
	}
}
