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

public class HowmanyDropDown {
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
	@Test
	public void numofDropdown()
	{
		driver.get("https://pynishant.github.io/dropdown-visibility-demo.html");
		List<WebElement> dropdown=driver.findElements(By.tagName("select"));
		System.out.println("Number of dropdowns: "+dropdown.size());
		//WebElement languagedrop=driver.findElement(By.xpath("//div[@class='select-selected']"));
		//languagedrop.click();
		//WebElement dropdown1=driver.findElement(By.xpath("//select[@id='lang1']"));
		//Select select1=new Select(dropdown1);
		//select1.selectByIndex(2);
		//WebElement dropdown2=driver.findElement(By.id("cars"));
		//Select select2=new Select(dropdown2);
		//WebElement dropdown4=driver.findElement(By.id("lang2"));
		//Select select4=new Select(dropdown4);
		WebElement dropdown4=driver.findElement(By.xpath("//select[@id='lang2']"));
		Select select4=new Select(dropdown4);
		select4.selectByValue("c#");
		select4.selectByValue("python");
		select4.deselectByValue("c#");
		
		
		
	}
}
