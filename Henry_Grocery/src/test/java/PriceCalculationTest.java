import java.io.FileReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Properties;

import src.main.java.PriceCalculation;

public class PriceCalculationTest {

	/*private PriceCalculation prdPrice;
	FileReader fr = new FileReader("price.properties");
    Properties prop = new Properties();
    //prop.load(fr);
    
    double soupPrice = Double.valueOf(prop.getProperty("SOUP_PRICE"));
    double breadPrice = Double.valueOf(prop.getProperty("BREAD_PRICE"));
    double milkPrice = Double.valueOf(prop.getProperty("MILK_PRICE"));
    double applePrice = Double.valueOf(prop.getProperty("APPLE_PRICE"));
    
	@Test
	public void testCalculateBreadPrice() {
		double expected = 2.4;
		prdPrice = new PriceCalculation();
		LocalDate purchaseDate = LocalDate.parse("2019-06-26");
		double actual = prdPrice.calculateBreadPrice(LocalDate.now(), 0, GroceryShoppingConstants.BREAD_PRICE, 0,
				purchaseDate, 3);
		//Assert.assertEquals(expected, Double.parseDouble(new DecimalFormat("#.##").format(actual)));
	}*/
}
