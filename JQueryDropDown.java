import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("JustAnInputBox")).click();
		//selectChoiceValues(driver,"choice");
		//selectChoiceValues(driver,"choice1","choice2,"choice 1 2");
		//selectChoiceValues(driver,"all");
		
		

	}

	public static void selectChoiceValues(WebDriver driver, String... value)
	{
		List<WebElement> choicelist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item:choicelist)
			{
				String text=item.getText();
				
				for(String val:value)
				{
					if(text.equals(val))
					{
						item.click();
						break;
					}
				}
			}
		}
		else
		{
			for(WebElement item:choicelist)
			{
				item.click();
			}
		}
		
	}

}
