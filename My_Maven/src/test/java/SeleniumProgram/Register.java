package SeleniumProgram;

import java.util.List;

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

public class Register {
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
	public void registerpage() throws InterruptedException
	{
		driver.get("https://buffalocart.com/demo/billing/public/login");
		WebElement user=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		user.sendKeys("admin");
		password.sendKeys("123456");
		WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		WebElement endtour=driver.findElement(By.xpath("//button[@data-role='end']"));
		endtour.click();
		WebElement hometousermg=driver.findElement(By.xpath("//section[@class='sidebar']/ul/li[2]/a"));
		hometousermg.click();
		List<WebElement> sideBar=driver.findElements(By.xpath("//ul[@class='sidebar-menu']//a//span[@class='title']"));
		for(int i=0;i<sideBar.size();i++) {
			if(sideBar.get(i).getText().equalsIgnoreCase("Roles"))
			{
				sideBar.get(i).click();
			}
			}
		WebElement addrole=driver.findElement(By.id("name"));
		addrole.sendKeys("ken");
		List<WebElement> rolesOption=driver.findElements(By.xpath("//form[@id='role_add_form']//div[3][@class='row check_group']//div[@class='icheckbox_square-blue']//ins"));
		System.out.println(rolesOption);
		
		
		
		
	}
	
	
}
