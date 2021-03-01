package shoppingcart;

import com.shopping.*;

public class HomePage {
	public static void main(String[] args) {
		
		Navigation navigation = new Navigation();  
		System.out.println("                                                       Welcome to the balajimart" + "\n");
		navigation.callToAddCsvData();
		navigation.navigating();      
	}

}
