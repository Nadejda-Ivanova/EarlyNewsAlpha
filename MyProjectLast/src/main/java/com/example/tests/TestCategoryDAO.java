package com.example.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.model.Article;
import com.example.model.ArticleDAO;
import com.example.model.Category;
import com.example.model.CategoryDAO;
import com.example.model.InvalidDAOException;

public class TestCategoryDAO {

	@Test
	public void testCreateCategory() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category test= new Category("try me", "another stupid category", true, false, 3);
		int id = cat.addCategory(test);
		System.out.println("Article is created with id "+id);
	}
	
	@Test
	public void testGetCategoryNameById() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		Category test= new Category("try me", "another stupid category", true, false, 5);
		int id = cat.addCategory(test);
		String name = cat.getCategoryNameById(id);
		
		assertTrue(name.equals(test.getName()));
	}
	
	@Test
	public void testGetAllCategories() throws InvalidDAOException {
		CategoryDAO cat= new CategoryDAO();
		List <Category>all = new ArrayList<Category>();
		all=cat.getAllCategories();
		assertTrue(all!=null && !(all.isEmpty()));
	}

}
