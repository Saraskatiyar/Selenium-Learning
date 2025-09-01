package Testing.SeleniumFramework.TestComponents;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import Framework.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginpage;
	public WebDriver initializedriver() throws IOException {
		//initialize properties
		/*
		 * Properties prop = new Properties(); FileInputStream file = new
		 * FileInputStream(
		 * "C:\\Users\\DELL\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\resources\\GlobalData.Properties"
		 * ); prop.load(file); String browsername = prop.getProperty("Browser");
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
		
		}
	@BeforeMethod
	public LoginPage LaunchApplication() throws IOException {
		driver = initializedriver();
		loginpage = new LoginPage(driver);
		loginpage.GoTo();
		return loginpage;
	}
	

}
