package src.main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Properties;

import src.main.java.util.GroceryVaildation;

public class PriceCalculation {
	
	
	public double breadDiscountCalculation(double price, int breadQty, int soupQty, LocalDate currDate, LocalDate purDate, 
			double breadDiscountPrice) throws Exception{
			
		LocalDate breadDiscountStartDate = currDate.minusDays(1);
		LocalDate breadDiscountEndDate = breadDiscountStartDate.plusDays(7);
		FileReader fr = new FileReader("price.properties");
        Properties prop = new Properties();
        prop.load(fr);
        double brdDisPrice = Double.valueOf(prop.getProperty("BREAD_DISCOUNT_PRICE"));
		
		if(soupQty>2 && GroceryVaildation.discountDateValidation(purDate, breadDiscountStartDate,
				breadDiscountEndDate))
		{
			int breadDiscount = (int) Math.floor((soupQty/2));
			if(breadQty <= breadDiscount){
				breadDiscountPrice = breadDiscountPrice + (breadQty * brdDisPrice);
			}
			if(breadQty > breadDiscount)
			{
				breadDiscountPrice = breadDiscountPrice + ((breadDiscount * brdDisPrice)+((breadQty - breadDiscount)*price));
			}	
		}else{
			breadDiscountPrice =totalCaluculation(breadDiscountPrice, price, breadQty);
		}
		
		return breadDiscountPrice;
	}
	
	public double appleDiscountCalculation(double price, int appleQty, LocalDate currDate, LocalDate purDate, 
			double appleDiscountPrice){
		
		LocalDate appleDiscountStartDate = currDate.plusDays(3);
		LocalDate appleDiscountEndDate = YearMonth.from(appleDiscountStartDate.plusMonths(1)).atEndOfMonth();
		
		if (GroceryVaildation.discountDateValidation(purDate, appleDiscountStartDate,
				appleDiscountEndDate)) {
			appleDiscountPrice = appleDiscountPrice + (appleQty * (price - (price * 10 / 100)));
		} else {
			appleDiscountPrice = totalCaluculation(appleDiscountPrice, price, appleQty);
		}
				
		return appleDiscountPrice;
	}
	
	/*
	 * Method to calculate subtotal of purchased item
	 */
	public double totalCaluculation(double totAmt, double price, int qty) {
		totAmt = totAmt + (qty * price);
		return totAmt;
	}
}
