import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrapdropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> Producttypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println("Number of options:"+Producttypes.size());
		selectoption(Producttypes,"Cards");
		
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> Products=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println("Number of options:"+Products.size());
		for(WebElement product:Products)
		{
			if(product.getText().equals("Saving Accounts"));
			{
				product.click();
				break;
			}
		}

	}
	
	
	
	//2 method
	public static void selectoption(List<WebElement> option, String value)
	{
		for(WebElement ptype:option)
		{
			if(ptype.getText().equals("Cards"));
			{
				ptype.click();
				break;
			}
		}
	}

}
