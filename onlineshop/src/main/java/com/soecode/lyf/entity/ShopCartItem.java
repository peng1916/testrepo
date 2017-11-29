package com.soecode.lyf.entity;

public class ShopCartItem {
	private long userId;
	private long productId;
	private int quantity;
	private int status;
	
	public ShopCartItem(){
		
	}
	
	public ShopCartItem( long userId, long productId, int quantity, int status ){
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer:userId=[" + this.userId + "], productId=[" + this.productId + "]";
	}

}
