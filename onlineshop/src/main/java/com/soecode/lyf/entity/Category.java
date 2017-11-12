package com.soecode.lyf.entity;

public class Category {
	private long id;
	private String name;
	private long parentId;
	private String description;
	
	public Category(){
		
	}
	
	public Category( long id, String name, long parentId, String description ){
		this.id= id;
		this.name = name;
		this.parentId = parentId;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Customer:id=[" + this.id + "], name=[" + this.name + "]";
	}

}
