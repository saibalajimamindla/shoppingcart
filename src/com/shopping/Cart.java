package com.shopping;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.awt.Desktop;
import java.util.ArrayList;

public class Cart extends Inventry {
	static int userCount = 1;
	static double totalIncome=0;

	public Cart() {

	}

	private int ItemsInCart = 0;
	private static ArrayList<Item> cart = new ArrayList();
	
	public void cartAdd(int enteredProductId, int enteredQuantity) {
		/**
		
		**/
		int flag = 0;
		for (Item inventryItem : inventry) {
			if (enteredProductId == inventryItem.getID()) {
				int id = inventryItem.getID();
				if (inventryItem.getQuantity() >= enteredQuantity && enteredQuantity > 0) {
					String name = inventryItem.getName();
					double price = inventryItem.getPrice();
					int quant = enteredQuantity;
					cart.add(new Item(id, name, price, quant));
					ItemsInCart++;
					flag++;
					System.out.println("Item " + enteredProductId + " added to cart");
					long a = inventryItem.getQuantity() - enteredQuantity;
					inventryItem.setQuantity(a);
				}
			}
		}
		if (flag <= 0) {
			System.out.println("Entered quantity is not found ");
			flag = 0;
		}
		flag = 0;
	}

	public void cartView() {
		System.out.println("there are " + ItemsInCart + " items in the cart");
		System.out.println("productid          Name          price          Quantity   ");
		for (Item cartItem : cart) {
			System.out.println(cartItem.getID() + "                   " + cartItem.getName() + "           "
					+ cartItem.getPrice() + "                    " + cartItem.getQuantity());
		}
		cartprice();
	}

	public void cartRemove(int idToRemove) {
		int count = 0;
		for (Item cartitem : cart) {
			if (idToRemove == cartitem.getID()) {
				for (Item inventryItem : inventry) {
					if (idToRemove == inventryItem.getID()) {
						inventryItem.setQuantity(cartitem.getQuantity());
					}
				}
				cart.remove(cartitem);
				count++;
				System.out.println("item is remove from the cart");
				break;
			}
		}
		if (count <= 0) {
			System.out.println("Entered item not removed ");
			count = 0;
		}
		count = 0;

	}

	public void cartprice() {
		double cartprice = 0;
		for (Item item : cart) {
			cartprice += (item.getPrice() * item.getQuantity());
		}
		System.out.println("the price of your cart is " + cartprice);
		cartprice = 0;
	}

	public void clearcart() {
		cart.removeAll(cart);
	}

	public static void cartbill() {
		double price = 0;
		for (Item item : cart) {
			price += (item.getPrice() * item.getQuantity());
		}
		totalIncome = totalIncome + price;
		System.out.println("Your bill is " + price);
		try {
			writeToBill();
		} catch (IOException e) {
			e.printStackTrace();
		}
		price = 0;
	}

	public static void writeToBill() throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();
		String fileName = "user" + userCount + "bill.txt";
		String location = "D:\\Billing\\" + fileName;
		File fileToWrite = new File(location);
		fileToWrite.createNewFile();
		fileToWrite.setWritable(true);
		PrintWriter writeToBill = new PrintWriter(new FileWriter(fileToWrite));
		writeToBill.println("********************************* YOUR BILL *********************************");
		writeToBill.println("productid          Name          price          Quantity   ");
		cart.forEach(item -> {
			String itemDetails = item.getID() + "                   " + item.getName() + "		  " + item.getPrice()
					+ "		   " + item.getQuantity();
			writeToBill.println(itemDetails);
		});
		writeToBill.println("******************************************************************************");
		double price = 0;
		for (Item item : cart) {
			price += (item.getPrice() * item.getQuantity());
		}
		String bill = "Your bill is " + price;

		writeToBill.println(bill);
		writeToBill.println("                        Thanks for shopping with us                 ");
		writeToBill.println("                            Please visit again                           "+"\n");
		writeToBill.println("Date\\Time of purchase is "+dtf.format(now));
		userCount++;
		price = 0;

		writeToBill.flush();
		writeToBill.close();
		File fileToOpen = new File(location);
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (fileToOpen.exists())
					desktop.open(fileToOpen);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}