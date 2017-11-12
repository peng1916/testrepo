package com.soecode.lyf.entity;

public class ShopCartItem {
	private long id;
	private long cartId;
	private long productId;
	private int quantity;
	private int status;
	
	public ShopCartItem(){
		
	}
	
	public ShopCartItem( long id, long cartId, long productId, int quantity, int status ){
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
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
		return "Customer:id=[" + this.id + "], cartId=[" + this.cartId + "]";
	}

}
