package com.example.model;

import java.time.LocalDateTime;

public class Comment {
	private int id;
	private String author;
	private String title;
	private LocalDateTime dateAdded;
	private String text;
	private Article iBelongTo;
	
	
	
	
	public Comment(String author, String title, String text, Article iBelongTo) {
		super();
		this.author = author;
		this.title = title;
		this.text = text;
		this.iBelongTo = iBelongTo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Article getiBelongTo() {
		return iBelongTo;
	}
	public void setiBelongTo(Article iBelongTo) {
		this.iBelongTo = iBelongTo;
	}
	
	
}
