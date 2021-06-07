package SeleniumProgram;

import java.util.Iterator;
import java.util.Set;

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

public class ToolsQAhw {
	public WebDriver driver;

	public void testInitialize(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\JavaC\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\GeckoFiles\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\EdgeFiles\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
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
		// driver.quit();
	}

	@Test(enabled=false)
	public void newTab() throws InterruptedException {
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow = driver.getWindowHandle();
		// System.out.println(parentWindow);
		WebElement newT = driver.findElement(By.id("tabButton"));
		newT.click();
		Thread.sleep(3000);
		Set<String> handlesId = driver.getWindowHandles();
		Iterator<String> it = handlesId.iterator();
		while (it.hasNext()) {
			// System.out.println(it.next());
			String childWindow = it.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				String expectedString = "This is a sample page";
				WebElement newTabText = driver.findElement(By.id("sampleHeading"));
				String actualString = newTabText.getText();
				// System.out.println(actualString);
				Assert.assertEquals(actualString, expectedString, "Mismatch!!!Error Again!!!");

			}
		}
	}
	@Test(enabled=false)
public void newWindow() throws InterruptedException
{
	driver.get("https://demoqa.com/browser-windows");
	String parentWindow = driver.getWindowHandle();
	WebElement nextWindow=driver.findElement(By.id("windowButton"));
	nextWindow.click();
	Thread.sleep(3000);
	Set<String> windowHandles=driver.getWindowHandles();
	Iterator<String> it=windowHandles.iterator();
	while(it.hasNext())
	{
		String childWindow=it.next();
		if(!parentWindow.equalsIgnoreCase(childWindow))
		{
			driver.switchTo().window(childWindow);
			String expectedMessage="This is a sample page";
			WebElement nextWindowMessage=driver.findElement(By.id("sampleHeading"));
			String actualMessage=nextWindowMessage.getText();
			Assert.assertEquals(actualMessage, expectedMessage,"Mismatch!!!Error Again!!!");
		}
				
	}

}
	@Test(enabled=true)
	public void newWMessage() throws InterruptedException
	{
		driver.get("https://demoqa.com/browser-windows");
		String parentWindow = driver.getWindowHandle();
		WebElement nextMWindow=driver.findElement(By.id("messageWindowButton"));
		nextMWindow.click();
		Thread.sleep(3000);
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		while(it.hasNext())
		{
			String childWindow=it.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				String expectedMessage="Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
				WebElement nextWindowMessage=driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
				 String actualMessage = nextWindowMessage.getText();
				Assert.assertEquals(actualMessage, expectedMessage,"Mismatch!!!Error Again!!!");
			}
		
	}
	}

}
