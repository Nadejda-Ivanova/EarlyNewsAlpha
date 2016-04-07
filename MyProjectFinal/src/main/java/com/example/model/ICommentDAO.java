package com.example.model;

import java.util.List;

import com.example.model.InvalidDAOException;
import com.example.model.Comment;


import java.sql.ResultSet;
import java.sql.SQLException;



public interface ICommentDAO {
	public int createComment(Comment comment) throws InvalidDAOException;

	public List<Comment> getAllCommentsByArticleId(int articleId) throws InvalidDAOException;
	
	public void deleteComment(Comment comment) throws InvalidDAOException;
	
	public List<Comment> getAllBad() throws InvalidDAOException;
	
	public Comment buildCommentFromDB(ResultSet rs) throws SQLException;
	
	public Comment getCommentById(int commentId) throws InvalidDAOException;
	
	public Comment getFirstBad() throws InvalidDAOException;
	
	public void setCommentAsOK(int id) throws InvalidDAOException;
	
	

}

