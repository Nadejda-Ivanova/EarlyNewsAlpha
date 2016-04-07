package com.example.model;

import java.time.LocalDateTime;

public class Video {

	private int id;
	private String name;
	private String path;
	private LocalDateTime dateAdded;
	private Article iBelongTo;
	
	
	public Video() {
		this.dateAdded=LocalDateTime.now();
			}
	public Video(String name, String path,Article iBelongTo) {
		this.name=name;
		this.path=path;
		this.iBelongTo=iBelongTo;
		this.dateAdded=LocalDateTime.now();
		
	}
	public Video(String name, String path,Article iBelongTo,LocalDateTime dateAdded){
		this(name,path,iBelongTo);
		this.dateAdded=dateAdded;
		
	}
	

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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

	public Article getiBelongTo() {
		return iBelongTo;
	}

	public void setiBelongTo(Article iBelongTo) {
		this.iBelongTo = iBelongTo;
	}

	

	
	
}
