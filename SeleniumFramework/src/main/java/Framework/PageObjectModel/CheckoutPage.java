package Framework.PageObjectModel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.AbstractComponents.AbstractClass;

public class CheckoutPage extends AbstractClass{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".action__submit") WebElement Submit;
	@FindBy(xpath = "(//button[@type='button'])[2]") WebElement selectcountry;
	@FindBy(css = "[placeholder='Select Country']") WebElement Country;
	By results = By.cssSelector(".ta-results");
	
	public void SelectCountry(String countryname) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, " India").build().perform();
		WaitElement(results);
		selectcountry.click();	
	}
	
	public ConfirmationPage submitorder() {
		Submit.click();
		return new ConfirmationPage(driver);
	}

}
