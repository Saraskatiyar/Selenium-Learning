import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {
	 public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			/*
			 * try { // Call the method to test Facebook login with incorrect credentials
			 * testFacebookLoginWithInvalidCredentials(driver, "wrongemail@example.com",
			 * "wrongpassword"); } catch (Exception e) { e.printStackTrace(); } finally { //
			 * Close the browser driver.quit(); }
			 */
	    }
	   public static void testFacebookLoginWithInvalidCredentials(WebDriver driver, String email, String password) {
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get("https://www.facebook.com/");
			
			/*WebElement button = driver.findElement(By.xpath("//label[contains(text(),'Impressive')]"));	
			
			/driver.manage().window().maximize();
			
			boolean isdisplayed = button.isDisplayed();
			System.out.println("displayed status is:" + isdisplayed);
			
			//button.click();
			boolean isselected = button.isSelected();
			System.out.println("yes it is:" + isselected);
			
			//Unselect radio button
			WebElement anotherbutton = driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
			//anotherbutton.click();
			}*/
			
			WebElement emailf = driver.findElement(By.id("email"));
			emailf.sendKeys("email@gmail.com");
			
			WebElement passwordf = driver.findElement(By.id("pass"));
			passwordf.sendKeys("123");
			
			WebElement loginButton = driver.findElement(By.name("login"));
	        loginButton.click();		
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'The password that you've entered is incorrect.")));
	        assert errorMessage.isDisplayed() : "Error message is NOT displayed!";
            assert errorMessage.getText().contains("The email address or mobile number") : "Incorrect error message text!";
            
            System.out.println("Test Passed: Error message displayed correctly.");

	 }
	 
}
