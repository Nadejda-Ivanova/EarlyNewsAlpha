package com.example.model;

import java.time.LocalDateTime;

public class Video {

	private int id;
	private String name;
	private LocalDateTime addedOn;
	private Image image;
	
	public Video() {
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

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
	
}
