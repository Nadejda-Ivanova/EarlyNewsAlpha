package com.example.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.Comment;
import com.example.model.CommentDAO;
import com.example.model.InvalidDAOException;

public class TestCommentDAO {

	@Test
	public void testCreateComment() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category category = cat.getCategoryById(1);
		ArticleDAO testArticle = new ArticleDAO();
		Article art = new Article("Rabotata vurvi ot zle na po-zle", "nqma vreme",category );
		int id = testArticle.createArticle(art);
		Comment com = new Comment("nadq", "banda uplasheni programisti shturmuvat birariq", "zklfhbv", art);
		CommentDAO dao= new CommentDAO();
		int finalId = dao.createComment(com);
		System.out.println("Comment is created with id "+finalId);
	}

}
