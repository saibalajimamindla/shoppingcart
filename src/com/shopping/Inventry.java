package com.shopping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Inventry {

	private int invitemCount;
	
	static ArrayList<Item> inventry = new ArrayList<>();

	public Inventry() {
		invitemCount = 0;
	}

	/**
	 * updatingCsvData(); this method is used to update data to local csv file
	 * after a purchase has been made by the customer.
	 * 
	 */
	public void updatingCsvData() {
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";
		final String FILE_HEADER = "id,Name,price,quantity";
		FileWriter fileWriter = null;
		try {
			File writeFile = new File("Items.csv");
			writeFile.createNewFile();
			writeFile.setReadable(true);
			fileWriter = new FileWriter(writeFile);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new student object list to the CSV file
			for (Item item : inventry) {
				fileWriter.append(String.valueOf(item.getID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(item.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(item.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(item.getQuantity()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
	public void updatingCsvDataAudit() {
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";
		final String FILE_HEADER = "id,Name,price,quantity";
		FileWriter fileWriter = null;
		try {
			File writeFile = new File("Items.csv");
			writeFile.createNewFile();
			writeFile.setReadable(true);
			fileWriter = new FileWriter(writeFile);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new student object list to the CSV file
			for (Item item : inventry) {
				fileWriter.append(String.valueOf(item.getID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(item.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(item.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(item.getQuantity()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append("income");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(""+Cart.totalIncome);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}

	/**
	 * addingcsvdata(); this method is used to read data from local csv file and
	 * and add item objects to the inventry .
	 */
	public void addingCsvData() {
		final String COMMA_DELIMITER = ",";
		final int ITEM_ID_INDEX = 0;
		final int ITEM_NAME_INDEX = 1;
		final int ITEM_PRICE_INDEX = 2;
		final int ITEM_QUANTITY_INDEX = 3;

		BufferedReader fileReader = null;
		try {

			String line = "";
			File readFile = new File("Items.csv");
			readFile.createNewFile();
			readFile.setReadable(true);

			fileReader = new BufferedReader(new FileReader(readFile));

			// Reading the CSV file header to skip it so we can read the data
		line =	fileReader.readLine();
			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				String[] cell = line.split(COMMA_DELIMITER);
				if (cell.length > 0) {
					Item item = new Item(Integer.parseInt(cell[ITEM_ID_INDEX]), cell[ITEM_NAME_INDEX],
							Double.parseDouble(cell[ITEM_PRICE_INDEX]), Integer.parseInt(cell[ITEM_QUANTITY_INDEX]));
					inventry.add(item);
				}
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
	}

	public void invAdd(int itemID, String itemName, double itemPrice, int itemQuantity) {
		inventry.add(new Item(itemID, itemName, itemPrice, itemQuantity));
		invitemCount += 1;
		System.out.println("Item " + itemName + " added to inventry" + "\n");

	}

	public void invRemove(int productIdToRemove) {
		int count = 0;
		for (Item item : inventry) {
			if (productIdToRemove == item.getID()) {
				count++;
				inventry.remove(item);
				System.out.println("Item is removed ");
				break;

			}
		}
		if (count == 0) {
			System.out.println("Item not found");
		}

	}

	public void update(int updatedID, double updatedPrice, int updatedQuantity) {
		int count = 0;
		for (Item item : inventry) {
			if (updatedID == item.getID()) {
				count++;
				item.setPrice(updatedPrice);
				item.setQuantity(updatedQuantity);
				System.out
						.println(item.getID() + "updated to Price : " + updatedPrice + " Quantity :" + updatedQuantity);

			}
		}
		if (count == 0) {
			System.out.println("Item not found");
		}

	}

	public void inventryView() {
		System.out.println("Number of items in inventry are " + invitemCount);
		System.out.println("productid          Name          price          QuantityAvilable   ");
		inventry.forEach(item -> {
			System.out.println(item.getID() + "                   " + item.getName() + "           " + item.getPrice()
					+ "                    " + item.getQuantity());
		});
	}

	public void userView() {
		System.out.println("productid          Name          price          QuantityAvilable   ");
		inventry.forEach(item -> {
			System.out.println(item.getID() + "                   " + item.getName() + "           " + item.getPrice()
					+ "                    " + item.getQuantity());
		});
	}

}
