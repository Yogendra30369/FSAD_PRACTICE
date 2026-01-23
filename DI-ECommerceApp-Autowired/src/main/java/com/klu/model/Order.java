package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component

public class Order {
	private int orderId;
	private String customerName;
	private int quantity;
	@Autowired
	private Product product;
	
	public Order() {
		this.orderId=2005;
		this.customerName="Yogendra";
		this.quantity=3;
	}
	public void display() {
		System.out.println("the following are the order details:");
		System.out.println("OrderId:"+orderId);
		System.out.println("CustomerName:"+customerName);
		System.out.println("quantity:"+quantity);
		System.out.println("productId:"+product.getProductId());
		System.out.println("productName:"+product.getProductName());
		System.out.println("price:"+product.getPrice());
		System.out.println("Category:"+product.getCategory());
	}
	
}
