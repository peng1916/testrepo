package com.soecode.lyf.entity;

public class Orderdetail {
	private long id;
	private String name;
	private int quantity;
	private long productId;
	private long orderId;
	
	public Orderdetail(){
		
	}
	
	public Orderdetail( long id, String name, int quantity, long productId, long orderId ){
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.productId = productId;
		this.orderId = orderId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Orderdetail:id=" + this.id + ", name=" + this.name;
	}

	
}
