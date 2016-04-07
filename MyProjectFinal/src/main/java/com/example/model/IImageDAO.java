package com.example.model;

import java.util.List;

public interface IImageDAO {
	
	int addImage(Image image) throws InvalidDAOException;

	public void deleteImage(Image image) throws InvalidDAOException;

	public Image getImageById(int imageId) throws InvalidDAOException;

	public List<Image> getAllImagesByArticleId(int articleId) throws InvalidDAOException;
}
