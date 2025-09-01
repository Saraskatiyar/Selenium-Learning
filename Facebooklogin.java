import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebooklogin {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		try {
			
			driver.get("https://www.facebook.com/");
			
			WebElement emailf = driver.findElement(By.id("email"));
			emailf.sendKeys("email@gmail.com");
			
			WebElement passwordf = driver.findElement(By.id("pass"));
			passwordf.sendKeys("123");
			
			WebElement loginButton = driver.findElement(By.name("login"));
	        loginButton.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),The password that you've entered is incorrect.")));
	        assert errorMessage.isDisplayed() : "Error message is NOT displayed!";
            assert errorMessage.getText().contains("The email address or mobile number") : "Incorrect error message text!";
            
            System.out.println("Test Passed: Error message displayed correctly.");
            
			
		} finally {
			driver.quit();
		}
		}
		
	}

 

