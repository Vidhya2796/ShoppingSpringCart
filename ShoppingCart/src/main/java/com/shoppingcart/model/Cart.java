package com.shoppingcart.model;

public class Cart {
	private int productId,userId,productPrice,quantity,totalAmount;
	String productName;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int productId, int userId, int productPrice, int quantity,
			int totalAmount, String productName) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", userId=" + userId + ", productPrice=" + productPrice + ", quantity="
				+ quantity + ", totalAmount=" + totalAmount + ", productName=" + productName + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
