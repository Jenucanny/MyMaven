package SeleniumProgram;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownHW {
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
	}

	@BeforeMethod
	public void setUp() throws Exception {
		testInitialize("firefox");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}@Test
	public void DropdownHandle()
	{
		driver.get("https://demoqa.com/select-menu");
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Purple");
		List<String> expectedList=new ArrayList();
		expectedList.add("Red");
		expectedList.add("Blue");
		expectedList.add("Green");
		expectedList.add("Yellow");
		expectedList.add("Purple");
		expectedList.add("Black");
		expectedList.add("White");
		expectedList.add("Voilet");
		expectedList.add("Indigo");
		expectedList.add("Magenta");
		expectedList.add("Aqua");
		List<WebElement> actualList=select.getOptions();
		if(expectedList.size()==actualList.size())
		{
			for(int i=0;i<actualList.size();i++) {
				
				String expectedTxt=expectedList.get(i);
				String actualTxt=actualList.get(i).getText();
				Assert.assertEquals(actualTxt,expectedTxt,"Failed!!!");
			}
			
		}
		else
			System.out.println("Size Differs");
	}

}
