package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
@Controller
@MultipartConfig
public class PictureUploadController {
	//DA puhna static bloka vuv ImageDAO?
	static{
	    File picsFolder = new File("C:\\pics");
			if (!picsFolder.exists()) {
				picsFolder.mkdir();
			}
	 }
	
	private static final String PICTURE_FORMAT = ".jpg";
	private static final String PICTURE_FOLDER = "C:\\pics\\";
	private static final int BUFFER_SIZE = 1024;

	@RequestMapping(value="/Upload", method=RequestMethod.POST)
	public void uploadAllPictures(HttpServletRequest request) {
		ArrayList<InputStream> streams = new ArrayList<InputStream>();
		int pictureLine =0;
			try {
				ArrayList<Part> allFiles = (ArrayList<Part>) request.getParts();
				for(int i =0; i<allFiles.size(); i++){
					if(allFiles.get(i)!= null){
						streams.add(allFiles.get(i).getInputStream());
					}
				}
				for(int i =0; i<streams.size(); i++){
					System.out.println(i);
//					pictureLine = dao.insertPictureDymmyLoc();
//					createPicture(PICTURE_FOLDER+pictureLine+PICTURE_FORMAT, streams.get(i));
//					dao.updatePicture(pictureLine, PICTURE_FOLDER+pictureLine+PICTURE_FORMAT);
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
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
*/
