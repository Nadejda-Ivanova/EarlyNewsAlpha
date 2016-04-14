package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import com.example.model.InvalidDAOException;

import com.example.model.CategoryDAO;

import com.example.model.Article;


public class ArticleDAO extends AbstractDAO implements IArticleDAO{


private static final String GET_ALL_ARTICLES = "SELECT * FROM earlyedition.articles";
	private static final String CREATE_NEW_ARTICLE_SQL = "INSERT INTO earlyedition.articles VALUES (null, ?, ?,?,null,?);";
	private static final String EDIT_ARTICLE_SQL = "UPDATE earlyedition.articles SET title = ?, text = ?, date_modified=? , category_id=? WHERE id = ?;";
	private static final String DELETE_ARTICLE_BY_ID = "DELETE * FROM earlyedition.articles WHERE id = ?";
	private static final String GET_ARTICLE_BY_ID = "SELECT * FROM earlyedition.articles WHERE id = ?";
	private static final String GET_ARTICLE_ID_FOR_LIST = "SELECT id FROM earlyedition.articles WHERE category_id = ?";

	
	
	@Override
	public int createArticle(Article article) throws InvalidDAOException {
		if (article!=null){
			try {
				
				
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_ARTICLE_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				//id title text dateAdded dateModified category category_id
				
				ps.setString(1, article.getTitle());
				ps.setString(2, article.getText());
				Timestamp timeStamp =Timestamp.valueOf(article.getDateAdded());
				java.sql.Date date = new java.sql.Date(timeStamp.getTime());
				ps.setDate(3,date);

//				CategoryDAO cat= new CategoryDAO();
//				int categoryId = cat.getCategoryIdByName(article.getCategory().getName());
				ps.setInt(4, article.getCategory().getId());
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				
				int id =result.getInt(1);
				
				article.setId(id);
			
				
				return id;


				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new InvalidDAOException("Your article cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This article is null. Try again.");
		}
	}

	@Override
	public void editArticle(Article article) throws InvalidDAOException {
		
		
		if(article!=null){
			try {
				PreparedStatement ps = getCon().prepareStatement(EDIT_ARTICLE_SQL);
				
				ps.setString(1, article.getTitle());
				ps.setString(2, article.getText());
				LocalDateTime t= LocalDateTime.now();
				article.setDateModified(t);
				Timestamp timeStamp =Timestamp.valueOf(t);
				java.sql.Date date = new java.sql.Date(timeStamp.getTime());
				ps.setDate(3,date);
				int categoryId=article.getCategory().getId();
				ps.setInt(4, categoryId);
				
				
				
				ps.setInt(5, article.getId());
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InvalidDAOException("Your article cannot be edited right now. Sorry about that", e);
			}
		}
		else {
			throw new InvalidDAOException("Your article is null.Try again.");
		}
		
	}

	@Override
	public void deleteArticle(Article article) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(DELETE_ARTICLE_BY_ID);
			ps.setInt(1, article.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
			} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("The article  cannot be removed right now . Try again later.", e);
		}
		
	}

	@Override
	public List<Article> getAllArticlesByCategoryName(String category) throws InvalidDAOException {
		List <Article>articles=new ArrayList<Article>();
		
		
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_ARTICLE_ID_FOR_LIST);
			CategoryDAO cat=new CategoryDAO();
			int categoryId=cat.getCategoryIdByName(category);
			ps.setInt(1, categoryId);
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				articles.add(this.getArticleById(result.getInt(1)));
				
			}
			
			return articles;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("No articles from this category " + category + " can be found . Try again later.");

		}
	}
	

	@Override
	public Article getArticleById(int articleId) throws InvalidDAOException {
		Article articleToReturn = null;
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_ARTICLE_BY_ID);
			ps.setInt(1, articleId);
			ResultSet result = ps.executeQuery();
			result.next();
			String title=result.getString(2);
			String text=result.getString(3);
			int categoryId=result.getInt(6);
			CategoryDAO cat = new CategoryDAO();
			Category category = cat.getCategoryById(categoryId);
			articleToReturn=new Article(title,text, category);
			articleToReturn.setId(articleId);
				return articleToReturn;
						
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("An article with id " + articleId + " cannot be found . Try again later.");

		}
	}
	public List<Article> doMeASearch (String search) throws InvalidDAOException{
		List<Article> searchResults = new ArrayList<Article>();
		List<Article> baseForSearch = new ArrayList<Article>();
		baseForSearch=this.getAllArticles();
		for (Article article: baseForSearch){
			if (article.getTitle().contains(search) || article.getText().contains(search)){
			searchResults.add(article);
			
			
		}
		}
		
		return searchResults;
	}
	



	@Override
	public List<Article> getAllArticles() throws InvalidDAOException {
		List <Article>articles=new ArrayList<Article>();
		
		
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_ALL_ARTICLES);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				articles.add(this.getArticleById(result.getInt(1)));
				
			}
			
			return articles;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("No articles exist. Try again later");

		}
	}
	

}
