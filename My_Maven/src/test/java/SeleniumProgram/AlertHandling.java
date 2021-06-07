package SeleniumProgram;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandling {
	public WebDriver driver;
	public void testInitialize(String browser) throws Exception {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\JavaC\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\GeckoFiles\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\EdgeFiles\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		else {
			throw new Exception("Ivalid browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}@BeforeMethod
	public void setUp() throws Exception {
		
		testInitialize("firefox");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	@Test
	public void handlingAlerts()
	{
	driver.get("http://demo.guru99.com/test/delete_customer.php");	
	WebElement customerId=driver.findElement(By.name("cusid"));
	customerId.sendKeys("1234");
	WebElement submit=driver.findElement(By.name("submit"));
	submit.click();
	Alert alert=driver.switchTo().alert();
	String actualText=alert.getText();
	String expectedText="Do you really want to delete this Customer?";
	Assert.assertEquals(actualText,expectedText,"Mismatch Error!!");
	alert.accept();
	//alert.dismiss();
	}
	
}


