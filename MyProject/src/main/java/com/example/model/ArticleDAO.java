package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;


public class ArticleDAO extends AbstractDAO implements IArticleDAO{
	private static final String CREATE_NEW_ARTICLE_SQL = "INSERT INTO article VALUES (null, ?, ?,?,?,?,null);";
	private static final String EDIT_ARTICLE_SQL = "UPDATE article SET title = ?, text = ?, category_id=? WHERE id = ?;";
	private static final String DELETE_ARTICLE_BY_ID = "DELETE * FROM article WHERE id = ?";
	private static final String GET_ARTICLE_BY_ID = "SELECT * FROM ARTICLE WHERE id = ?";
	

	@Override
	public int createArticle(Article article) throws InvalidDAOException {
		java.sql.Timestamp stampTime = Timestamp.valueOf(LocalDateTime.now());
		if (article!=null){
			try {
					
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_ARTICLE_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, article.getTitle());
				ps.setString(2, article.getText());
				ps.setTimestamp(3, stampTime);
				ps.setTimestamp(4, stampTime);
				int categoryId = article.getCategory().getId();
				ps.setInt(3, categoryId);
				ResultSet result = ps.getGeneratedKeys();
				int id =result.getInt(1);
				article.setId(id);
				ps.executeUpdate();
				result.next();
				
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
		
		//sushtoto za datite i videoto
		if(article!=null){
			try {
				PreparedStatement ps = getCon().prepareStatement(EDIT_ARTICLE_SQL);
				//title text category_id id
				ps.setString(1, article.getTitle());
				ps.setString(2, article.getText());
				CategoryDAO cat=new CategoryDAO();
				int categoryId=article.getCategory().getId();
				ps.setInt(3, categoryId);
				ps.setInt(4, article.getId());
				
				ps.executeUpdate();

				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InvalidDAOException("Your article cannot be edited right now. Sorry about that");
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
			throw new InvalidDAOException("The article  cannot be removed right now . Try again later.");
		}
		
	}

	@Override
	public List<Article> getAllArticlesByCategoryName(String category) {
		// TODO Auto-generated method stub
		return null;
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
			articleToReturn.setDateAdded(result.getTimestamp(4).toLocalDateTime());
			articleToReturn.setDateAdded(result.getTimestamp(5).toLocalDateTime());
			articleToReturn.set
			return articleToReturn;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("An article with id " + articleId + " cannot be found . Try again later.");

		}
	}

}
