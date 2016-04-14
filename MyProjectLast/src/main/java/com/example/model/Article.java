package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDateTime;
import java.util.List;

public class Article {

	private int id;
	private String title;
	private String text;
	private LocalDateTime dateAdded;
	private LocalDateTime dateModified;
	private Category category;
	private String catId;
	

	
	public Article() {
	}

	public Article(String title, String text, Category category) {
		this.dateAdded=LocalDateTime.now();
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

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}
@Override
public boolean equals(Object obj){
	Article art=(Article)obj;
	if(this.id==art.getId() && this.title.equals(art.getTitle()) && this.text.equals(art.getText())){
		return true;
	}
	return false;
}

	



	

	


	



}
