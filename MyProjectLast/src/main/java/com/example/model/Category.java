package com.example.model;

public class Category {
	private int id;
	public String name;
	private String description;
	private boolean top;
	private boolean main;
	private int sortOrder;
	
	public Category (){
		
	}
	
	
	
	
	public Category(String name, String description, boolean top, boolean main, int sortOrder) {
		
		this.name = name;
		this.description = description;
		this.top = top;
		this.main = main;
		this.sortOrder = sortOrder;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTop() {
		return top;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
	public boolean isMain() {
		return main;
	}
	public void setMain(boolean main) {
		this.main = main;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return name;
	}

	
	
	
}
