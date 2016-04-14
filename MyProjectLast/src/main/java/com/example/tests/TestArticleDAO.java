package com.example.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;

public class TestArticleDAO {

	@Test
	public void testCreateArticle() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category category = cat.getCategoryById(1);
		ArticleDAO testArticle = new ArticleDAO();
		Article art = new Article("Rabotata vurvi ot zle na po-zle", "nqma vreme",category );
		int id = testArticle.createArticle(art);
		System.out.println("Article is created with id "+id);
	}
	
	@Test
	public void testGetArticleById() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category category = cat.getCategoryById(1);
		ArticleDAO testArticle = new ArticleDAO();
		Article art = new Article("Rabotata vurvi ot zle na po-zle", "nqma vreme",category );
		int id = testArticle.createArticle(art);
		Article art2=testArticle.getArticleById(id);
		assertEquals(art, art2);
	}
	
	@Test (expected=InvalidDAOException.class)
	public void testDeleteArticle() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category category = cat.getCategoryById(1);
		ArticleDAO testArticle = new ArticleDAO();
		Article art = new Article("Rabotata vurvi ot zle na po-zle", "nqma vreme",category );
		int id = testArticle.createArticle(art);
		testArticle.deleteArticle(art);
		testArticle.getArticleById(id);
		
		
	}
	
	@Test 
	public void testGetAllArticles() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category category = cat.getCategoryById(1);
		String name=category.getName();
		ArticleDAO art = new ArticleDAO();
		List <Article>test = art.getAllArticlesByCategoryName(name);
		assertTrue(!(test.isEmpty()) && test!=null );
		
	}
	
	
}


	



	
