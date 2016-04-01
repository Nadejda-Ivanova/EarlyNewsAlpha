package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;
import com.example.model.Comment;

public class CommentDAO extends AbstractDAO implements ICommentDAO{
	private static final String CREATE_NEW_COMMENT_SQL = "INSERT INTO users VALUES (null, ?, ?,null,?,?);";
	private static final String DELETE_COMMENT_BY_ID = "DELETE * FROM comment WHERE id = ?";

	@Override
	public int createComment(Comment comment) throws InvalidDAOException {
		
		if (comment!=null){
			try {
				
				// otnovo datite
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_COMMENT_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				ps.setString(1, comment.getAuthor());
				ps.setString(2, comment.getTitle());
				ps.setString(3, comment.getText());
				Article myArticle = comment.getiBelongTo();
				
				ps.setInt(4, myArticle.getId());
				ResultSet result = ps.getGeneratedKeys();
				int id =result.getInt(1);
				
				comment.setId(id);
				ps.executeUpdate();
				result.next();
				
				return id;


				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new InvalidDAOException("Your comment cannot be created right now. Sorry about that. ");
			}
		} else {
			throw new InvalidDAOException("This comment is null. Try again.");
		}
	}

	@Override
	public List<Comment> getAllCommentsByArticleId(int articleId) throws InvalidDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Comment comment) throws InvalidDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement(DELETE_COMMENT_BY_ID);
			ps.setInt(1, comment.getId());
			ResultSet result = ps.executeQuery();
			result.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("The comment  cannot be removed right now . Try again later.");
		}
		
	}

}
