package SeleniumProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHW {
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
			throw new Exception("Invalid browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		testInitialize("firefox");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
    @Test(enabled=false)
	public void verifyLogin() {
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement userName = driver.findElement(By.name("userName"));
		WebDriverWait wait=new WebDriverWait(driver,90);
		//wait.until(ExpectedConditions.visibilityOf(userName));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
		userName.sendKeys("test123");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12345");
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}
    
    @Test(enabled=false)
    public void verifyPageTitle()
    {
    	driver.get("http://demo.guru99.com/test/newtours/");
    	String expectedPageTiltle="Welcome: Mercury Tour";
    	String actualTitle=driver.getTitle();
    	Assert.assertEquals(actualTitle, expectedPageTiltle,"PageTitleNotFound");
    }
    @Test(enabled=true)
    public void verifyButtonEnabled()
    {
    driver.get("http://demowebshop.tricentis.com/");	
    WebElement registerHome=driver.findElement(By.xpath("//a[@class='ico-register']"));
    registerHome.click();
    WebElement register=driver.findElement(By.id("register-button"));
    boolean expectedValue=true;
    boolean actualValue=register.isEnabled();
    //Assert.assertTrue(actualValue, "register button displayed");
    Assert.assertFalse(actualValue,"register button enabled");	
    }

}
