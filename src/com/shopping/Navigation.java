package com.shopping;

import java.util.Scanner;

public class Navigation {
	public static StringBuffer userId = new StringBuffer("admin");
	public static StringBuffer password = new StringBuffer("password");

	public void updatePassword(String updateId, String updatePassword) {
		userId.replace(0, userId.length(), updateId);
		password.replace(0, password.length(), updatePassword);
	}



	public void navigating() {
		Inventry inventry = new Inventry();
		Scanner scan = new Scanner(System.in);
		Admin admin = new Admin();
		User user = new User();

		int menuChoice = 0;
		int attempt;
		String inputUserId;
		String inputPassword;
		String oldUserIdRefernce;
		String oldPasswordReference;

		System.out.println(
				"//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(" Identify Your self");
		System.out.println("     1) User" + "\n" + "     2) Admin" + "\n" + "     3) Exit");
		try {
			menuChoice = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Entered value is invalid");
			navigating();
		}

		switch (menuChoice) {
		case 1:
			user.userIsIn();
			break;
		case 2:
			for (attempt = 0; attempt < 3; attempt++) {
				if (attempt > 0) {
					System.out.println("\n" + (3 - attempt) + " attempts left" + "\n");
				}
				System.out.println("Please enter the credentials ");
				System.out.println("Enter the Admin name ");
				inputUserId = scan.next();
				System.out.println("Enter the password");
				inputPassword = scan.next();
				oldUserIdRefernce = (String) userId.subSequence(0, userId.length());
				oldPasswordReference = (String) password.subSequence(0, password.length());
				if (oldUserIdRefernce.equalsIgnoreCase(inputUserId)
						& oldPasswordReference.equalsIgnoreCase(inputPassword)) {
					attempt = 4;
					try {
						admin.adminIn();
					} catch (Exception e) {
						System.out.println("Entered details are invalid");
						admin.adminIn();
					}
				} else {
					if (attempt < 2) {
						System.out.println("\n" + "invalid username or password ");
						System.out.println("Hint.....username: " + userId.substring(0, 1) + "......."
								+ userId.substring((userId.length() - 1), userId.length()) + "  password:"
								+ password.substring(0, 2) + "............");
						System.out.println("Please try again " + "\n");
					}

				}
			}
			System.out.println("invalid credentials exiting application");
			System.exit(0);
			break;
		case 3:
			System.out.println("Thank you :)");
			System.exit(0);
			break;

		default:
			System.out.println("inavlid input ");
			navigating();

		}

	}

	public void callToAddCsvData() {
		Inventry inventry = new Inventry();
		inventry.addingCsvData();
		
	}

}
