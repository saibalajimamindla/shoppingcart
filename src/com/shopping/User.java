package com.shopping;

import java.util.Scanner;

public class User {
	Inventry inventry = new Inventry();
	Cart cart = new Cart();
	Navigation navigation = new Navigation();
	Scanner scan = new Scanner(System.in);

	protected void userIsIn() {
		User user = new User();
		int menuLooping = 0;
		int menuChoice = 0;
		int selectedId;
		int selectedQuantity;
		System.out.println(
				"//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n" + "welcome to your cart ");
		System.out.println("These are the items avilable at store");
		inventry.userView();

		while (menuLooping < 10) {
			System.out.println(
					".......................................................................................................................................");
			System.out.println("Menu :");
			System.out.println("1) Add item into cart" + "\n" + "2) Remove item from cart" + "\n" + "3) View cart "
					+ "\n" + "4) Checkout " + "\n");
			try {
				menuChoice = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Entered value is invalid");
				userIsIn();
			}

			switch (menuChoice) {
			case 1:
				System.out.println("Entering items into cart: ");
				selectedId = user.id();
				selectedQuantity = user.quantity();
				cart.cartAdd(selectedId, selectedQuantity);
				break;
			case 2:
				System.out.println("Removing items fron the cart: ");
				selectedId = user.id();
				cart.cartRemove(selectedId);
				break;
			case 3:
				System.out.println("The items in your cart are: ");
				cart.cartView();
				break;
			case 4:
				inventry.updatingCsvData();
				cart.cartbill();
				System.out.println("\n" + "Thanks for shopping with us");
				System.out.println("Please visit again" + "\n");
				cart.clearcart();
				navigation.navigating();

			default:
				System.out.println("inavlid");
				userIsIn();
			}
		}

	}
	
	int id()
	{
		User user = new User();
	System.out.println("Enter item ID: ");
	System.out.println("NOTE: input should be numeric");
		try{
		int  id = scan.nextInt();
		return id;
		}catch (Exception e)
		{
			System.out.println("inavalid entry");
			user.id();
		}
		return 0;
	}
	

int quantity()
{
	User user = new User();
	System.out.println("Enter quantity: ");
	System.out.println("NOTE: input should be numeric");
	try{
	int  quantity = scan.nextInt();
	return quantity;
	}catch (Exception e)
	{
		System.out.println("inavalid entry");
		user.quantity();
	}
	return 0;
}

}
