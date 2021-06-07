package SeleniumProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
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
	public void handlingDropdown()
	{
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
        register.click();
        WebElement dropdown=driver.findElement(By.xpath("//select[@name='country']"));
        Select select=new Select(dropdown);
        //select.selectByVisibleText("ANGOLA");
        //select.selectByIndex(4);
		select.selectByValue("ANGOLA");
		List<WebElement> actualCountryList=select.getOptions();
		for(int i=0;i<actualCountryList.size();i++)
		{
			String country=actualCountryList.get(i).getText();
			System.out.println(country);
		}
	}
}


