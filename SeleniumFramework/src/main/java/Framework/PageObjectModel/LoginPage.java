package Framework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponents.AbstractClass;

public class LoginPage extends AbstractClass {
	
	 WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver); //this is used to invoked parent class constuctor variable 
		//Initilization, this. refers to the local class or current class
		this.driver=driver;
		//this refers to object of current class 
		
		//Create method to trigger the elements, when we call this method, it takes the driver 
		//as arguements.
		PageFactory.initElements(driver, this);
	}
	//WebElement usermail = driver.findElement(By.id("userEmail"));
	
	//We can also write this by page factory
	@FindBy(id="userEmail") WebElement userEmail;
	//This will be constructed on running time like driver and assign to the varibale what 
	//i declared.
	@FindBy(id="userPassword") WebElement password;
	@FindBy(id="login") WebElement submit;
	@FindBy(css="[class*='flyInOut']") WebElement errorcheck;
	
	//Action methods
	public ProductList loginApplication(String Email, String passwordElement)
	{
		userEmail.sendKeys(Email);
		password.sendKeys(passwordElement);
		submit.click();
		ProductList productlist = new ProductList(driver);
		return productlist;
	}
	public String geterror() {
		return errorcheck.getText();
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}

//class -property and method
//object - propert or method