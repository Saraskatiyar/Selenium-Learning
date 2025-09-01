import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("")).click();
		//using send keys
		driver.findElement(By.xpath("")).sendKeys("File path");
		
		//using robot class method
		WebElement button=driver.findElement(By.xpath(""));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].cliclk();", button);
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		StringSelection ss=new StringSelection("FILE PATH AND PDF NAME");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//ctrl+v
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		//enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_ENTER);
	}

}
