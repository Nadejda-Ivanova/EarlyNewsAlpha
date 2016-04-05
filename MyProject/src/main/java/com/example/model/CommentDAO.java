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

public class CommentDAO extends AbstractDAO implements ICommentDAO {
	private static final String GET_FIRST_COMMENTS = "SELECT * FROM earlyedition.comment where bad_comment=1 order by date_added limit 1";
	private static final String CREATE_NEW_COMMENT_SQL = "INSERT INTO earlyedition.comment VALUES (null, ?, ?,?,?,0,0,0,?);";
	private static final String DELETE_COMMENT_BY_ID = "DELETE FROM earlyedition.comment WHERE id = ?";
	private static final String SET_OK = "update earlyedition.comment set bad_comment=0 where id=?";

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
		
		Comment temp = new Comment();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_FIRST_COMMENTS);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
			temp = buildCommentFromDB(rs);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InvalidDAOException("No bad comments found");
		}

		return temp;

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
	public int createComment(Comment comment) throws InvalidDAOException {
		java.sql.Timestamp stampTime = Timestamp.valueOf(LocalDateTime.now());
		if (comment != null) {
			try {

				// otnovo datite
				PreparedStatement ps = getCon().prepareStatement(CREATE_NEW_COMMENT_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, comment.getAuthor());
				ps.setString(2, comment.getTitle());
				ps.setTimestamp(3, stampTime);
				ps.setString(4, comment.getText());
				ps.setInt(5, comment.getArticle().getId());
				ps.executeUpdate();
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int id = result.getInt(1);
				return id;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new InvalidDAOException("Your comment cannot be created right now. Sorry about that. ", e);
			}
//ot tova maj njama nugda? comment null?
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
	public void deleteMultipleComments(ArrayList<Comment> badList) throws InvalidDAOException{
		for(Comment comment:badList){
			deleteComment(comment);
		}
	}
}
