package Framework.PageObjectModel;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.AbstractComponents.AbstractClass;

public class CartPage extends AbstractClass {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".totalRow button") WebElement ProductList;
	@FindBy(css=".cartSection h3") private List<WebElement> ProductTitles;
	
	public boolean ProductDisplay(String prodname) {
		boolean match = ProductTitles.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(prodname));
		return(match);
		
	}
	public CheckoutPage GoToCheckout() {
		ProductList.click();
		return new CheckoutPage(driver);
		
	}
		
}
