package com.soecode.lyf.entity;

public class Shopcart {
	private long id;
	private int status;
	private long userId;
	
	public Shopcart(){
		
	}
	
	public Shopcart( long id, int status, long userId ){
		this.id = id;
		this.status = status;
		this.userId = userId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Customer:id=[" + this.id + "], userId=[" + this.userId + "]";
	}

}
