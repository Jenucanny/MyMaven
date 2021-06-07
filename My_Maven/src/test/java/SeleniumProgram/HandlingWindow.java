package SeleniumProgram;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWindow {
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
	public void windowHandle() throws InterruptedException
	{
		driver.get("http://demo.guru99.com/popup.php");
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		WebElement click=driver.findElement(By.xpath("//a[text()='Click Here']"));
		click.click();
		Thread.sleep(3000);
		
		Set<String> handlesId=driver.getWindowHandles();
		Iterator<String> it=handlesId.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			String childWindow=it.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				WebElement email=driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("juju@gmail.com");
				WebElement submit=driver.findElement(By.name("btnLogin"));
				submit.click();
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		
		}
	}


