package com.example.model;

import com.example.model.InvalidDAOException;


import java.sql.ResultSet;

import java.util.ArrayList;


public interface ICategoryDAO {
	public String getCategoryNameById(int categoryId) throws InvalidDAOException;
	
	public int getCategoryIdByName(String categoryName)throws InvalidDAOException;
	
	public int addCategory(Category category) throws InvalidDAOException;
	
	public void buildCategory(ResultSet rs, Category cat) throws InvalidDAOException;
	
	public ArrayList<Category> getAllCategories() throws InvalidDAOException;
	
	
	
}

