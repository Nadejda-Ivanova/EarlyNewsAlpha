package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Article;
import com.example.model.Comment;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import com.example.model.Article;
import com.example.model.Comment;


public class CommentDAO extends AbstractDAO implements ICommentDAO {
	private static final String GET_BAD_COMMENTS = "SELECT * FROM earlyedition.comments where bad_comment='true' order by date_added";
	private static final String CREATE_NEW_COMMENT_SQL = "INSERT INTO earlyedition.comments VALUES (null, ?,?,?,?,0,0,?,?)";
	private static final String DELETE_COMMENT_BY_ID = "DELETE FROM earlyedition.comments WHERE id = ?";
	private static final String GET_COMMENT_BY_ID = "SELECT * FROM earlyedition.comments WHERE id = ?";
	private static final String GET_COMMENT_ID_FOR_LIST = "SELECT id FROM earlyedition.comments  WHERE article_id = ?";
	private static final String GET_FIRST_COMMENTS = "SELECT * FROM earlyedition.comments where bad_comment=1 order by date_added limit 1";
	private static final String SET_OK = "update earlyedition.comments set bad_comment=0 where id=?";

	
	
	public List<Comment> getAllBad() throws InvalidDAOException {
		List <Comment>comments=new ArrayList<Comment>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_BAD_COMMENTS);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				comments.add(buildCommentFromDB(result));
				
			}
			
			return comments;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("No bad comments can be displayed now . Try again later.");

		}

	}

	public Comment buildCommentFromDB(ResultSet rs) throws SQLException {
		Comment currentComment = new Comment();
		currentComment.setId(rs.getInt(1));
		currentComment.setAuthor(rs.getString(2));
		currentComment.setTitle(rs.getString(3));
		currentComment.setDateAdded(rs.getTimestamp(4).toLocalDateTime());
		currentComment.setText(rs.getString(5));
		currentComment.setLikes(rs.getInt(6));
		currentComment.setDislikes(rs.getInt(7));
		if (rs.getInt(8) == 1) {
			currentComment.setBad(true);
		} else {
			currentComment.setBad(false);
		}
		ArticleDAO artDAO = new ArticleDAO();
		try {
			currentComment.setArticle(artDAO.getArticleById(rs.getInt(9)));
		} catch (InvalidDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentComment;
	}

	@Override
	public int createComment(Comment comment) throws InvalidDAOException {
		
		if (comment!=null){
			try {
				
				
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_COMMENT_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				//author title dateAdded text likes dislikes bad_comment article_id
				
				ps.setString(1, comment.getAuthor());
				ps.setString(2, comment.getTitle());
				Timestamp timeStamp =Timestamp.valueOf(comment.getDateAdded());
				java.sql.Date date = new java.sql.Date(timeStamp.getTime());
				ps.setDate(3,date);
				ps.setString(4, comment.getText());
				ps.setBoolean(5, false);
				
				int articleId = comment.getiBelongTo().getId();
				ps.setInt(6, articleId);
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				
				result.next();
				int id =result.getInt(1);
				
				comment.setId(id);
			
				
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
	public List<Comment> getAllCommentsByArticleId(int articleId) throws InvalidDAOException {
		List <Comment>comments=new ArrayList<Comment>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_COMMENT_ID_FOR_LIST);
			
			
			ps.setInt(1, articleId);
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				comments.add(this.getCommentById(result.getInt(1)));
				
			}
			
			return comments;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("No comment for article with this id " + articleId + " can be displayed now . Try again later.");

		}
	}
	
	public void deleteCommentById(int id) throws InvalidDAOException{
		 try {
			PreparedStatement prep = getCon().prepareStatement(DELETE_COMMENT_BY_ID);
			prep.setInt(1, id);
			prep.execute();
		} catch (SQLException e) {
				e.printStackTrace();
				throw new InvalidDAOException("Comment not found check id", e);
		}
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
	public Comment getCommentById(int commentId) throws InvalidDAOException {
		Comment commentToReturn = null;
		
		try {
			PreparedStatement ps = getCon().prepareStatement(GET_COMMENT_BY_ID);
			ps.setInt(1, commentId);
			ResultSet result = ps.executeQuery();
			
			
			result.next();
			
			
			String author=result.getString(2);
			String title=result.getString(3);
			String text=result.getString(5);
			int articleId=result.getInt(8);
			ArticleDAO art= new ArticleDAO();
			Article iBelongTo= art.getArticleById(articleId);
			
			
			commentToReturn=new Comment(author,title,text, iBelongTo);
			return commentToReturn;
			

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InvalidDAOException("Comment with id " + commentId + " cannot be found . Try again later.");

		}
	}
	public void setCommentAsOK(int id) throws InvalidDAOException{
		try {
			PreparedStatement prep = getCon().prepareStatement(SET_OK);
			prep.setInt(1, id);
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("Bad status not changed", e);
		}
	}
	
	
	
	
	public Comment getFirstBad() throws InvalidDAOException {
		
		Comment temp = null;
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_FIRST_COMMENTS);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				temp = new Comment();	
			temp = buildCommentFromDB(rs);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("No bad comments found");
		}

		return temp;

	}

}
