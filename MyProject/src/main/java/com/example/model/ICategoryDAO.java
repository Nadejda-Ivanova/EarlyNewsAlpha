package com.example.model;

import com.example.model.InvalidDAOException;

public interface ICategoryDAO {
	public String getCategoryNameById(int categoryId) throws InvalidDAOException;
	public int getCategoryIdByName(String categoryName)throws InvalidDAOException;
}
