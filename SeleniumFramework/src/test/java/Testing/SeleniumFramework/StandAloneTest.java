package Testing.SeleniumFramework;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prodname = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("Unknown@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anything!123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//Products to load and visible on the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = Products.stream().filter(products-> products.findElement(By.cssSelector("b"))
				.getText().equals(prodname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng aniamting
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector(".ng-animating"))));
		//this line is giving performance issue
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//Checking the cart page 
		//Xpath = //*[@class='cartSection']/h3
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(prodname));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		//Checking out cart
		Actions a = new Actions(driver);
		//build.perform is mandatory for this
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), " India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		//.ta-item::nth-of-type(1)
		//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String thankyou = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(thankyou.equalsIgnoreCase("Thankyou for the order"));
		driver.close();
		

	}

}
