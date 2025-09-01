package Framework.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Framework.PageObjectModel.CartPage;

public class AbstractClass {
	//For reusability of code
	WebDriver driver;
	
	public AbstractClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']") WebElement CartPage;

	public void WaitElement(By FindBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
    public void WaitWebElement(WebElement FindBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}

	public CartPage GoToCart() {
		CartPage.click();	
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		}
	
	public void WaitForElementToDisappear(WebElement ele) {
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//sending web element becuase there is find element
		//wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.invisibilityOfAllElements((ele)));
	}

}
