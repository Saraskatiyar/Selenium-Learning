import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		  driver.get("https://www.makemytrip.com/");
	      
		  WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(100));
		  Actions actions = new Actions(driver);
		  actions.moveByOffset(10, 10).click().perform();
		  
		  WebElement fromcity = driver.findElement(By.xpath("//input[@placeholder='From']"));
          fromcity.click();
          
          WebElement inputfield = driver.findElement(By.xpath("//input[@placeholder='From']"));
          inputfield.sendKeys("Mumbai");
		  //WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='From']"));
		  //input1.click();
	}
}
