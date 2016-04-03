package com.example.controller;


//OT VCHERA NOVO
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.model.PictureFileUpload;

@Controller
public class NewPictureUploadController {

	@RequestMapping(value="/newupload", method=RequestMethod.GET)
	public String createArt(Model model){
		model.addAttribute("newUpload", new PictureFileUpload());
		return "secondUpload";
	}
	
}
