package com.example.model;

import java.time.LocalDateTime;

public class Image {
	private int id;
	private String name;
	private LocalDateTime dateAdded;
	private boolean isThumbnail;
	private int artId;
	
	
	public Image() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDateTime getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}


	public boolean isThumbnail() {
		return isThumbnail;
	}


	public void setThumbnail(boolean isThumbnail) {
		this.isThumbnail = isThumbnail;
	}


	public int getArtId() {
		return artId;
	}


	public void setArtId(int artId) {
		this.artId = artId;
	}
	
	
	
	
}
