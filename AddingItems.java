import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingItems {
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.amazon.in/gp/product/B0D6Z1YPTZ/ref=sw_img_1?smid=A2GTG1HPYW8M2P&th=1");
		driver.get("https://blinkit.com/");
		
		//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		List<WebElement> product=driver.findElements(By.cssSelector(".AddToCart__UpdatedButtonContainer-sc-17ig0e3-0.lmopxc"));
		for(int i=0;i<product.size();i++) {
			String name = product.get(i).getText();
			if (name.contains("Amul Salted Butter")) {
				driver.findElement(By.xpath("Add button xpath")).click();
			}
		}

}
}
