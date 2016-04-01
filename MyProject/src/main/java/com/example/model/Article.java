package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Article {

	private int id;
	private String title;
	private String text;
	private LocalDateTime dateAdded;
	private LocalDateTime dateModified;
	private Category category;
	private String image;
	private String video;
	private String catId;
	private String categoryName;

	public Article() {
	}

	public Article(String title, String text, Category category) {
		super();
		this.title = title;
		this.text = text;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", text=" + text + ", dateAdded=" + dateAdded
				+ ", dateModified=" + dateModified + ", category=" + category + ", image=" + image + ", video=" + video
				+ ", catId=" + catId + ", categoryName=" + categoryName + "]";
	}

	

	


	



}
