package SeleniumProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Upload {
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
	   @Test(enabled=true)
	    public void methodUpload()
	    {
	    	driver.get("http://demo.guru99.com/test/upload/");
	    	WebElement uploadfile=driver.findElement(By.id("uploadfile_0"));
	    	uploadfile.sendKeys("E:\\SeleniumFiles\\data.txt");
	    	WebElement checkbox=driver.findElement(By.id("terms"));
	    	checkbox.click();
	    	WebElement submit=driver.findElement(By.id("submitbutton"));
	    	submit.click();
	    	
	    }

}
