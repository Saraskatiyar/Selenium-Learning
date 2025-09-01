import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multipledropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		
		
		 //Select noofemployee=new Select(driver.findElement(By.name("NoOfEmployee")));
		 //noofemployee.selectByVisibleText("16 - 20");
		 
		 //Select industrydrp=new Select(driver.findElement(By.name("industry")));
		 //industrydrp.selectByVisibleText("Travel");
		  
		 //Select countrydrp=new Select(driver.findElement(By.name("country")));
		 //countrydrp.selectByVisibleText("Aruba");
		 
		
		WebElement noofemploye=driver.findElement(By.name("NoOfEmployee"));
		selectoption(noofemploye,"16 - 20");
		
		WebElement industrydrp=driver.findElement(By.name("industry"));
		selectoption(industrydrp,"Healthcare");
		
		WebElement countrydrp=driver.findElement(By.name("country"));
		selectoption(countrydrp,"India");
	}
	//Auto suggest dropdown code
	public static void selectoption(WebElement ele, String value)
	{
		Select drp=new Select(ele);
		List<WebElement>alloption=drp.getOptions();
		for(WebElement option:alloption)
		{
			if(option.getText().equals("Cuba"))
			{
				option.click();
				break;
			}
	}

	}
}
