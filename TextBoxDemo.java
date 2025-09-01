import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		//Identify text box
		WebElement EmailTextBox = driver.findElement(By.id("Email"));
		
		//textboxis displayed or not
		Boolean displyedstatus = EmailTextBox.isDisplayed();
		System.out.println("Dsiplyed status is: "+displyedstatus);
		
		//Enter value in text box
		EmailTextBox.sendKeys("Saras@mail.com");
		
		//get the entered value from text
		String enteredvalue = EmailTextBox.getAttribute("value");
		System.out.println(enteredvalue);

}
}