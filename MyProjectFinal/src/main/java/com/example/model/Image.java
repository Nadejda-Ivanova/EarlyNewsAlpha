package com.example.model;

import java.time.LocalDateTime;


public class Image {
	private int id;
	private String name;
	private String path;
	private LocalDateTime dateAdded;
	private boolean isThumbnail;
	private Article iBelongTo;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Article getiBelongTo() {
		return iBelongTo;
	}

	public void setiBelongTo(Article iBelongTo) {
		this.iBelongTo = iBelongTo;
	}

	public Image() {

	}

	public Image(String name, String path, boolean isThumbnail, Article iBelongTo) {
		this.dateAdded=LocalDateTime.now();
		this.name = name;
		this.path = path;
		this.isThumbnail = isThumbnail;
		this.iBelongTo = iBelongTo;
	}
	public Image(String name, String path, boolean isThumbnail, Article iBelongTo, LocalDateTime t){
		this(name,path,isThumbnail,iBelongTo);
		this.dateAdded=t;
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

}

