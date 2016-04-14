package com.example.model;



public interface IVideoDAO {
	
	
	int addVideo(Video video) throws InvalidDAOException;

	
	public void deleteVideo(Video video) throws InvalidDAOException;
	
	public Video getVideoById (int videoId) throws InvalidDAOException;
	
	public Video getVideoByArticleId(int articleId) throws InvalidDAOException;

}
