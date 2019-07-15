package src.main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

import src.main.java.util.GroceryVaildation;

public class PurchaseGrocery {

	public static void main(String[] args) throws Exception{
		
		
		
		Scanner input = new Scanner(System.in);

		LocalDate currDate = LocalDate.now();
		int groceryItems = 1;
		int soupQty = 0;
		double totalAmt = 0;
		double price = 0;
		
		PriceCalculation productPrice = new PriceCalculation();
		LocalDate purDate = null;
		System.out.println("Enter Purchase Date with the format yyyy-MM-dd");
		String date = input.next();
		purDate = GroceryVaildation.DateValidation(date);
		
		
            FileReader fr = new FileReader("price.properties");
            Properties prop = new Properties();
            prop.load(fr);
            double soupPrice = Double.valueOf(prop.getProperty("SOUP_PRICE"));
            double breadPrice = Double.valueOf(prop.getProperty("BREAD_PRICE"));
            double milkPrice = Double.valueOf(prop.getProperty("MILK_PRICE"));
            double applePrice = Double.valueOf(prop.getProperty("APPLE_PRICE"));
		
		while(groceryItems >=1){
			System.out.println("Welcome to Henry's GroceryStore"+"\n"+"\n");
			//System.out.println();
			System.out.println("Product   |  unit    |  cost");
			System.out.println("---------------------------");
			System.out.println("1.soup    |  tin     |" + soupPrice);
			System.out.println("2.bread   | loaf     |" + breadPrice);
			System.out.println("3.milk    |  bottle  |" + milkPrice);
			System.out.println("4.apples  |  single  |" + applePrice);
			System.out.println();
			System.out.println("0. Quit");
			System.out.println("");

			System.out.println("Please Select Product Number or Enter 0 to exit");
			groceryItems = input.nextInt();
			GroceryVaildation.prdtInputValidation(groceryItems, input);
			if (groceryItems == 0)
				break;
			
			
			System.out.println("Please enter the Quantity");
			int qty = input.nextInt();
			GroceryVaildation.prdtQtyValidation(qty, input);
			
			switch (groceryItems) {
			case 1:
				soupQty = qty;
				price = soupPrice;
				totalAmt = Math.floor(productPrice.totalCaluculation(totalAmt, price, qty));
				System.out.println(totalAmt);
				break;
			case 2:
				price = breadPrice;
				totalAmt = Math.floor(productPrice.breadDiscountCalculation(price, qty, soupQty, currDate, purDate, totalAmt));
				System.out.println(totalAmt);
				break;
			case 3:
				price = milkPrice;
				totalAmt = Math.floor(productPrice.totalCaluculation(totalAmt, price, qty));
				System.out.println(totalAmt);
				break;
			case 4:
				price = applePrice;
				totalAmt = Math.floor(productPrice.appleDiscountCalculation(price, qty, currDate, purDate,  totalAmt));
				System.out.println(totalAmt);
				break;
			default:
				break;
			}
			
		}
		
		if(groceryItems >=0)
			System.out.println("Total Amount for your purchase: "+totalAmt);
		
		
	}
	
}
