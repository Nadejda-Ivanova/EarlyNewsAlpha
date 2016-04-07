//package com.example.controller;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.time.LocalDateTime;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import dao.ArticleDao;
//import dao.CategoryDao;
//import dao.ImageDao;
//import exceptions.DatabaseException;
//import exceptions.NoPictureException;
//import model.Article;
//import model.Category;
//
//
//@WebServlet("/admin/uploadfile")
//@MultipartConfig
//public class CreateArticleServlet extends HttpServlet {
//
//	private static final String PICTURE_FORMAT = ".jpg";
//	private static final String PICTURE_FOLDER = "C:\\pics\\";
//	private static final long serialVersionUID = 1L;
//	private static final int BUFFER_SIZE = 1024;
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//	@RequestMapping()
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//		HttpSession session = request.getSession(true);
//		Part filePart = request.getPart("fileName");
//		InputStream fileContent = filePart.getInputStream();
//		int pictureLine = 0;
//		Article currentArticle = null;
//		try {
//			if (request.getPart("fileName") != null) {
////				File picsFolder = new File(pathname)
//				ImageDao dao = new ImageDao();
//				pictureLine = dao.insertPictureDymmyLoc();
//				
//				createPicture(PICTURE_FOLDER+pictureLine+PICTURE_FORMAT, fileContent);
//				dao.updatePicture(pictureLine, PICTURE_FOLDER+pictureLine+PICTURE_FORMAT);
//			}
//		
//			currentArticle = createArticleFromRequest(request);
//			currentArticle.setImage(new ImageDao().getPicturebyId(pictureLine));
//		} catch (NoPictureException e) {
//			currentArticle.setImage(null);
//		} catch (DatabaseException e) {
//			e.printStackTrace();
//			session.setAttribute("errorMessage", "Database error try again later");
//		}
//		ArticleDao daoArt = new ArticleDao();
//		daoArt.addArticle(currentArticle);
//		// response.getWriter().print(request.getParameter("category"));
//		// response.getWriter().print(request.getParameter("text"));
//	
//
//	}
//
//	public void createPicture(String path, InputStream fileContents) {
//		try {
//			byte[] buffer = new byte[BUFFER_SIZE];
//			FileOutputStream outputStream = new FileOutputStream(path);
//			int numBytes = 0;
//			do {
//				numBytes = fileContents.read(buffer, 0, BUFFER_SIZE);
//				if (numBytes <= 0)
//					break;
//				outputStream.write(buffer, 0, numBytes);
//			} while (numBytes > 0);
//			outputStream.close();
//		} catch (IOException ex) {
//			System.out.println("Error writing file '" + path + "'");
//			ex.printStackTrace();
//		}
//	}
//
//	public Article createArticleFromRequest(HttpServletRequest request) throws DatabaseException {
//		Article temp = new Article();
//		int categoryNumber = Integer.parseInt((request.getParameter("category")));
//		Category currentCat;
//	
//			currentCat = new CategoryDao().getCatById(categoryNumber);
//		temp.setCategory(currentCat);
//		temp.setText(request.getParameter("text"));
//		temp.setTitle(request.getParameter("title"));
//		temp.setAddedOn(LocalDateTime.now());
//		temp.setModifiedOn(LocalDateTime.now());
//
//		return temp;
//	}
//}
