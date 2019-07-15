package src.main.java.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GroceryVaildation {
	
	static LocalDate purchaseDate;
	
	public static LocalDate DateValidation(String date) {
		boolean flag;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				
				purchaseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy[-MM[-dd]]"));
				flag = false;
			} catch (DateTimeParseException e) {
				System.out.println("Date formate is incorrect please Enter correct formate");
				date = sc.next();
				flag = true;
			}
		} while (flag);
		return purchaseDate;
	}
	
	/*
	 * Method to validate discount price based on purchase date
	 */
	public static boolean discountDateValidation(LocalDate purchaseDate, LocalDate discountStartDate,
			LocalDate discountEndtDate) {
		return (purchaseDate.equals(discountStartDate) || purchaseDate.equals(discountEndtDate))
				|| (purchaseDate.isAfter(discountStartDate) && purchaseDate.isBefore(discountEndtDate));
	}
	
	public static void prdtQtyValidation(int qty, Scanner input) {
		while (qty < 0) {
			System.out.println("Please enter the correct Quantity for Grocery");
			qty = input.nextInt();
		}
	}
	
	public static void prdtInputValidation(int purItem, Scanner input) {
		while (purItem < 0 || purItem > 4) {
			System.out.println("Please enter the correct input for grocery items");
			purItem = input.nextInt();
		}
	}
	
	

}
