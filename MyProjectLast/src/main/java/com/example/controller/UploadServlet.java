package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Article;
import com.example.model.Image;
import com.example.model.ImageDAO;
import com.example.model.InvalidDAOException;

@WebServlet("/uploadfile")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	private static final String PICTURE_FORMAT = ".jpg";
	private static final String PICTURE = "";
	private static final String PICTURE_FOLDER = "C:\\Users\\mitaka\\Desktop\\2\\MyProject\\src\\main\\webapp\\static\\img\\";
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 1024;

	@RequestMapping()
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("loggeduser") != null) {
			response.setContentType("text/html");
			HttpSession session = request.getSession(true);
			Part filePart = request.getPart("file");
			InputStream fileContent = filePart.getInputStream();
			int pictureLine = 0;
			ImageDAO daoImg = new ImageDAO();
			try {
				pictureLine = daoImg.createDummyImage();
				// System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
				// "+ pictureLine);
			} catch (InvalidDAOException e) {
				e.printStackTrace();
				session.setAttribute("error", "Upload failed try again");
				response.sendRedirect("./uploadcontroller");
			}
			createPicture(PICTURE_FOLDER+PICTURE + pictureLine + PICTURE_FORMAT, fileContent);
			Article currentArticle = (Article) session.getAttribute("newArticle");
			Image dbImage = new Image();
			dbImage.setiBelongTo(currentArticle);
			dbImage.setId(pictureLine);
			dbImage.setName( PICTURE + pictureLine + PICTURE_FORMAT);
			dbImage.setPath( PICTURE +pictureLine + PICTURE_FORMAT);
			try {
				daoImg.updateDummyPicture(dbImage);
				// System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
				// ");
			} catch (InvalidDAOException e) {
				e.printStackTrace();
				session.setAttribute("error", "Upload failed try again");
				response.sendRedirect("./uploadcontroller");
			}
			session.setAttribute("success", "The picture was updated successfully");
			response.sendRedirect("./uploadcontroller");
		} else {
			response.sendRedirect("./login");

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
