package com.shopping;

public class Item {

	private int ProductId;
	private String productName;
	private double ProductPrice;
	private int ProductQuantity;

	public Item(int itemID, String itemName, double itemPrice, int itemQuantity) {
		ProductId = itemID;
		productName = itemName;
		ProductPrice = itemPrice;
		ProductQuantity = itemQuantity;

	}
	public Item()
	{
		
	}
	

	public int getID() {
		return ProductId;
	}

	public String getName() {
		return productName;
	}

	public double getPrice() {
		return ProductPrice;
	}

	public int getQuantity() {
		return ProductQuantity;
	}

	public double setPrice(double updatedPrice) {
		this.ProductPrice = updatedPrice;
		return ProductPrice;
	}

	public int setQuantity(int updatedQuantity) {
		this.ProductQuantity = ProductQuantity + updatedQuantity;
		return ProductQuantity;
	
	}
	
	public int setQuantity(long upqa) {
		this.ProductQuantity = (int)upqa;
		return ProductQuantity;
	
	}

}
