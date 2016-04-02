package com.example.controller;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.PictureFileUpload;

@Controller
public class UploadPicsController {
	
	 
	    //@RequestMapping(value = "/upload", method = RequestMethod.GET)
	    //public String crunchifyDisplayForm() {
	    //    return "uploadfile";
	    //}
	 
	    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	    public String savePictures(
	            @ModelAttribute("uploadForm") PictureFileUpload uploadForm,
	            Model map) throws IllegalStateException, IOException {
	        String saveDirectory = "c:/pics/";
	 System.out.println("in upload method, upload form " + (uploadForm.getFiles() == null ? "null" : uploadForm.getFiles().size()));
	        List<MultipartFile> crunchifyFiles = uploadForm.getFiles();
	 
	        List<String> fileNames = new ArrayList<String>();
	        System.out.println("Size " + crunchifyFiles.size());
	        if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
	            for (MultipartFile multipartFile : crunchifyFiles) {
	            	
	                String fileName = multipartFile.getOriginalFilename();
	                System.out.println("File Name " + fileName);
	                if (!"".equalsIgnoreCase(fileName)) {
	                    // Handle file content - multipartFile.getInputStream()
	                    multipartFile
	                            .transferTo(new File(saveDirectory + fileName));
	                    fileNames.add(fileName);
	                    System.out.println(saveDirectory + fileName);
	                }
	            }
	        }
	 
	        map.addAttribute("files", fileNames);
	        return "upload";
	    }
}
