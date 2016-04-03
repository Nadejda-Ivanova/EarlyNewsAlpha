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
	private static final String GET_BAD_COMMENTS = "SELECT * FROM earlyedition.comment where bad_comment=1 order by date_added";
	private static final String CREATE_NEW_COMMENT_SQL = "INSERT INTO users VALUES (null, ?, ?,?,?,0,0,0,?);";
	private static final String DELETE_COMMENT_BY_ID = "DELETE * FROM comment WHERE id = ?";

	public ArrayList<Comment> getAllBad() {
		ArrayList<Comment> temp = new ArrayList<Comment>();
		try {
			PreparedStatement prep = getCon().prepareStatement(GET_BAD_COMMENTS);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				temp.add(buildCommentFromDB(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
