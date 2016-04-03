package com.example.controller;
//OT VCHERA NOVO
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.FileUploadForm;
@MultipartConfig
@Controller
public class FileUploadController {
	private static final int BUFFER_SIZE = 1024;
 
	
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }
     
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model map) {
         
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
                File file = new File("C:\\pics\\01.jpg");
                try {
//                	multipartFile.getInputStream().
					createPicture("C:\\pics\\01.jpg", multipartFile.getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 
            }
        }
         
        map.addAttribute("files", fileNames);
        return "file_upload_success";
    }
    
    public void createPicture(String path, InputStream fileContents) {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			FileOutputStream outputStream = new FileOutputStream(path);
			int numBytes = 0;
			do {
				numBytes = fileContents.read(buffer, 0, BUFFER_SIZE);
				if (numBytes <= 0)
					break;
				outputStream.write(buffer, 0, numBytes);
			} while (numBytes > 0);
			outputStream.close();
		} catch (IOException ex) {
			System.out.println("Error writing file '" + path + "'");
			ex.printStackTrace();
		}
	}
}
