package Testing.SeleniumFramework;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Framework.PageObjectModel.CartPage;
import Framework.PageObjectModel.CheckoutPage;
import Framework.PageObjectModel.ConfirmationPage;
import Framework.PageObjectModel.LoginPage;
import Framework.PageObjectModel.ProductList;
import Testing.SeleniumFramework.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Submission extends BaseTest {
	
	@Test
	public void Submit() throws IOException{
		
		String prodname = "ZARA COAT 3";
		//LoginPage loginpage = LaunchApplication();
		ProductList productlist=loginpage.loginApplication("Unknown@gmail.com", "Anything!123");
		
		List<WebElement> Products = productlist.getproduct();
		productlist.addtocart(prodname);
		CartPage cartpage = productlist.GoToCart();
		
		boolean match = cartpage.ProductDisplay(prodname);
		cartpage.GoToCheckout();
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.GoToCheckout();
		checkoutpage.SelectCountry("India");
		ConfirmationPage confirmationpage = checkoutpage.submitorder();
		
		String verifymessage = confirmationpage.verifymessage();
		Assert.assertTrue(verifymessage.equalsIgnoreCase("Thankyou for the order"));
		driver.close();
		
	}
}

