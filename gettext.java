import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gettext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement inputbox =driver.findElement(By.id("Email"));
		//inputbox.clear();
		inputbox.sendKeys("saras@yourstore.com");
		
		//Capturing value from input box
		//inputbox.getAttribute("value");
		System.out.println("result:-"+ inputbox.getAttribute("value"));
		
	    //System.out.println("result:-"+ inputbox.getText("value"));
		//String chromeTitle = chromeTest(url: "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F\"");

	}
	/*
	 * public static String chromeTest(String url) { WebDriver driver = new
	 * ChromeDriver(); driver.get(url); String title = driver.getTitle();
	 * driver.quit(); return title; }
	 */

}
