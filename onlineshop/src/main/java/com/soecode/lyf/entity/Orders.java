package com.soecode.lyf.entity;

import java.security.Timestamp;

public class Orders {
	private long id;
	private Timestamp orderTime;
	private Timestamp payTime;
	private double orderMoney;
	private int orderSt;
	private String address;
	private String phone;
	private long customerId;
	
	public Orders(){
		
	}
	
	public Orders(long id, Timestamp orderTime, Timestamp payTime, double orderMoney, int orderSt, String address, String phone, long customerId){
		this.id = id;
		this.orderTime = orderTime;
		this.payTime = payTime;
		this.orderMoney = orderMoney;
		this.orderSt = orderSt;
		this.address = address;
		this.phone = phone;
		this.customerId = customerId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public Timestamp getPayTime() {
		return payTime;
	}
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public int getOrderSt() {
		return orderSt;
	}
	public void setOrderSt(int orderSt) {
		this.orderSt = orderSt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Customer:id=[" + this.id + "], customerId=[" + this.customerId + "]";
	}

}
