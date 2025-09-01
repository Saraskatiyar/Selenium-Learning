package Framework.PageObjectModel;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framework.AbstractComponents.AbstractClass;

public class ProductList extends AbstractClass {
	
	WebDriver driver;
	public ProductList(WebDriver driver) {
		
		super(driver);
		//Initilization, this. refers to the local class or current class
		this.driver=driver;
		
		//Create method to trigger the elements, when we call this method, it takes the driver as arguements.
		PageFactory.initElements(driver, this);
	}
	//WebElement usermail = driver.findElement(By.id("userEmail"));
	
	//We can also write this by page factory
	@FindBy(css=".mb-3") List<WebElement> Products;
	@FindBy(css=".ng-animating") WebElement waitforappear;
	By Prod = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By addmsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getproduct() {
		WaitElement(Prod);
		return Products;
	}
	
	public WebElement getProductByName(String ProductName) {
		WebElement prod = Products.stream().filter(products-> products.findElement(By.cssSelector("b"))
				.getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	public void addtocart(String ProductName) {
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addtocart).click();
		WaitElement(addmsg);
		WaitForElementToDisappear(waitforappear);
		
	}

}
