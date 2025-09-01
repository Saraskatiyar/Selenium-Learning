import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		WebElement drphandle=driver.findElement(By.id("Form_getForm_Country"));
		Select drpcountry=new Select(drphandle);      //if tagna	me is select then it is static dropdown
		//drpcountry.selectByVisibleText("India");
		//drpcountry.selectByValue("10");
		//drpcountry.selectByIndex(12);
		
		//selecting options from dropdown without using methods
		
		List<WebElement>alloption=drpcountry.getOptions();
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
