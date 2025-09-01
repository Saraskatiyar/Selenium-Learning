import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
    
    public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		//select specific checkbox
		WebElement  checkbox1= driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));//.click();
		
		boolean isdisplayedstatus = checkbox1.isDisplayed();
		System.out.println("yes it is: "+ checkbox1);
		System.out.println(checkbox1);
		checkbox1.click();
		//select all checkbox
		//List<WebElement>checkboxes=driver.findElements(By.xpath("//form[@id='checkbox']/input[1]"));
		//System.out.println("Total no of checks:"+checkboxes.size());
		

	}

}
