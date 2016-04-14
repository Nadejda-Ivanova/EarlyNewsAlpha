package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.time.LocalDateTime;

public class Comment {
	private int id;
	private String author;
	private String title;
	private LocalDateTime dateAdded;
	private String text;
	private Article iBelongTo;
	private int likes;
	private int dislikes;
	private boolean isBad;
	private boolean toBeDeleted;
	
	
	public boolean isToBeDeleted() {
		return toBeDeleted;
	}

	public void setToBeDeleted(boolean toBeDeleted) {
		this.toBeDeleted = toBeDeleted;
	}

	public Comment() {
		}
	
	public Comment(String author, String title, String text, Article article) {
		this.dateAdded=LocalDateTime.now();
		this.likes=0;
		this.dislikes=0;
		this.isBad=false;
		this.author = author;
		this.title = title;
		this.text = text;
		this.iBelongTo = article;
		
	}
	public Article getiBelongTo() {
		return iBelongTo;
	}

	public void setiBelongTo(Article iBelongTo) {
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
	public Article getArticle() {
		return iBelongTo;
	}
	public void setArticle(Article article) {
		this.iBelongTo = article;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public boolean isBad() {
		return isBad;
	}

	public void setBad(boolean isBad) {
		this.isBad = isBad;
	}
	
	
}

