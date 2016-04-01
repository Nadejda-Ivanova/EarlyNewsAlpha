package com.example.model;

import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Comment;


public interface ICommentDAO {
	public int createComment(Comment comment) throws InvalidDAOException;

	public List<Comment> getAllCommentsByArticleId(int articleId) throws InvalidDAOException;
	
	public void deleteComment(Comment comment) throws InvalidDAOException;

}
