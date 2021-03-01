package com.shopping;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

public class Admin {

	Inventry inventry = new Inventry();
	Navigation navigation = new Navigation();
	Scanner scan = new Scanner(System.in);

	protected void adminIn() {
		Admin admin = new Admin();
		int menuLooping = 0;
		int itemID;
		int itemQuantity;
		int menuChoice;
		int updatedId;
		int updatedPrice;
		int updatedQantity;
		int removeChoice;
		double itemPrice;
		String itemName;
		String oldUserId;
		String oldPassword;
		String newPassword;
		String newUserId;
		String oldUserIdReference;
		String oldPasswordReference;

		while (menuLooping < 10) {
			System.out.println(
					"//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("\n" + "Menu:");
			System.out.println("1) Add item into inventry" + "\n" + "2) update Quantity/prize from shop" + "\n"
					+ "3) Remove item from shop" + "\n" + "4) inventry view " + "\n"
					+ "5) Update username and password " + "\n" + "6) Exit" + "\n" + "7) Audit" + "\n");
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 6:
				System.out.println("\n" + "Getting you back to home screen");
				inventry.updatingCsvData();
				navigation.navigating();

			case 1:

				itemID = admin.id();// calling id method
				if (itemID == 0) {
					admin.id();
				}

				itemName = admin.itemName();// calling itemName method
				if (itemName == null) {
					admin.itemName();
				}

				itemPrice = admin.price();// calling price method
				if (itemPrice == 0) {
					admin.price();
				}

				itemQuantity = admin.quantity();// calling quantity method
				if (itemQuantity == 0) {
					admin.quantity();
				}

				inventry.invAdd(itemID, itemName, itemPrice, itemQuantity);

				break;

			case 2:
				System.out.println("Enter the itemid");
				updatedId = admin.id();
				System.out.println(
						"Enter the qunatity to be updated...(Enterd quantity will be added to the existing quantity )");
				updatedQantity = admin.quantity();
				System.out.println("Enter the price to be updated");
				updatedPrice = admin.price();
				inventry.update(updatedId, updatedPrice, updatedQantity);
				break;

			case 3:
				System.out.println("Enter Id of the item that you would like to remove: ");
				removeChoice = admin.id();
				inventry.invRemove(removeChoice);
				break;
			case 4:
				inventry.inventryView();
				break;

			case 5:
				for (int attempt = 0; attempt < 3; attempt++) {
					if (attempt > 0) {
						System.out.println("\n" + (3 - attempt) + " attempts left" + "\n");
					}
					System.out.println("Enter old user name");
					oldUserId = scan.next();
					System.out.println("Enter the old password");
					oldPassword = scan.next();
					oldUserIdReference = (String) navigation.userId.subSequence(0, navigation.userId.length());
					oldPasswordReference = (String) navigation.password.subSequence(0, navigation.password.length());
					if (oldUserId.equalsIgnoreCase(oldUserIdReference)
							& oldPassword.equalsIgnoreCase(oldPasswordReference)) {
						System.out.println("\n" + "Validation suscessful" + "\n");
						System.out.println("Enter new user name");
						newUserId = scan.next();
						System.out.println("Enter the new password");
						newPassword = scan.next();
						attempt = 4;
						navigation.updatePassword(newUserId, newPassword);
						System.out.println("username and password updated");
						adminIn();
					} else {
						System.out.println("Entered credentials are not matched");
					}
				}
				System.out.println("\n" + "invalid credentials exiting application");
				System.exit(0);
				break;
			case 7:
				inventry.updatingCsvDataAudit();
				File fileToOpen = new File("C:\\Users\\d1\\Documents\\balaji\\shopcartcsv\\Items.csv");
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (fileToOpen.exists())
							desktop.open(fileToOpen);
						Thread.sleep(1000);

					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			case 8:
				File LocaionToOpen = new File("D:\\Billing");
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (LocaionToOpen.exists())
							desktop.open(LocaionToOpen);

					}

				} catch (Exception e) {
					e.printStackTrace();

				}
				break;
				
			default:
				System.out.println("Invalid input");
				adminIn();
			}

		}

	}

	int id() {
		Admin admin = new Admin();
		System.out.println("Enter item ID: ");
		System.out.println("NOTE: input should be numeric");
		try {
			int id = scan.nextInt();
			return id;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			admin.id();
		}
		return 0;
	}

	int quantity() {
		Admin admin = new Admin();
		System.out.println("Enter quantity: ");
		System.out.println("NOTE: input should be numeric");
		try {
			int quantity = scan.nextInt();
			return quantity;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			admin.quantity();
		}
		return 0;
	}

	int price() {
		Admin admin = new Admin();
		System.out.println("Enter item price: ");
		System.out.println("NOTE: input should be numeric");
		try {
			int price = scan.nextInt();
			return price;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			admin.price();
		}
		return 0;
	}

	String itemName() {
		Admin admin = new Admin();
		System.out.println("Enter item Name: ");
		System.out.println("NOTE: input should be Alphabatic");
		try {
			String itemName = scan.next();
			return itemName;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			admin.price();
		}
		return null;
	}
}
