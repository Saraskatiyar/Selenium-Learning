import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksCount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.maccaron.in/en/");
		//Count of links on this page
		//System.out.println(driver.findElement(By.tagName("a")).getSize());
		
		//Counts of links on footer page
		WebElement footerdriver = driver.findElement(By.xpath("//footer[@id='desktop-footer']"));
		System.out.println(footerdriver.findElement(By.tagName("a")).getSize());
		
		 //Count links for specific Column 
		WebElement coloumndriver = driver.findElement(By.xpath("//body/div[@id='root']/footer[@id='desktop-footer']/div[1]/div[2]/div[1]"));
		System.out.println(coloumndriver.findElement(By.tagName("a")).getSize());
		 
		 //Click on each link and check if the pages are opening 
		 for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++) {
		 coloumndriver.findElements(By.tagName("a")).get(i).click(); }
		 

	}

}
