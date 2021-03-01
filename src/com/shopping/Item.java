package com.shopping;

public class Item {

	private int productId;
	private String productName;
	private double ProductPrice;
	private int productQuantity;

	public Item(int itemID, String itemName, double itemPrice, int itemQuantity) {
		productId = itemID;
		productName = itemName;
		ProductPrice = itemPrice;
		productQuantity = itemQuantity;

	}
	public Item()
	{
		
	}
	

	public int getID() {
		return productId;
	}

	public String getName() {
		return productName;
	}

	public double getPrice() {
		return ProductPrice;
	}

	public int getQuantity() {
		return productQuantity;
	}

	public double setPrice(double updatedPrice) {
		this.ProductPrice = updatedPrice;
		return ProductPrice;
	}

	public int setQuantity(int updatedQuantity) {
		this.productQuantity = productQuantity + updatedQuantity;
		return productQuantity;
	
	}
	
	public int setQuantity(long upqa) {
		this.productQuantity = (int)upqa;
		return productQuantity;
	
	}

}
