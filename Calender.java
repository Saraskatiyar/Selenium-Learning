import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
public static void main(String[] args) {
		
	    String date="10";
	    String year = "2025";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.cssSelector(".ng-tns-c58-10.ui-inputtext.ui-widget.ui-state-default")).click();
	//river.findElement(By.cssSelector(".ui-datepicker-title.ng-tns-c58-10")).click();
	//river.findElement(By.cssSelector(".ui-datepicker-next-icon.pi.pi-chevron-right")).click();
		driver.findElement(By.xpath("//span[contains(text(),'March')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'18')]")).click();
		driver.findElement(By.xpath("//a[contains(text()='"+date+"']")).click();
		
		
}

}
