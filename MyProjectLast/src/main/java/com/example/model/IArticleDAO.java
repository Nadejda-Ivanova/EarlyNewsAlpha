package com.example.model;

import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;


import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;


public interface IArticleDAO {
	public int createArticle(Article article) throws InvalidDAOException;

	
	public void editArticle(Article article) throws InvalidDAOException;

	
	public void deleteArticle(Article article) throws InvalidDAOException;
	
	public List<Article> getAllArticlesByCategoryName (String category) throws InvalidDAOException;
	
	public Article getArticleById (int articleId) throws InvalidDAOException;


	List<Article> getAllArticles() throws InvalidDAOException;
	
	

}

