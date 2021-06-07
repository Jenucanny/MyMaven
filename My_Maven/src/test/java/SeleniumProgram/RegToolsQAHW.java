package SeleniumProgram;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegToolsQAHW {
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
		//driver.close();
		//driver.quit();
	}
	@Test
	public void qaregForm() throws AWTException
	{
		
		driver.get("https://demoqa.com/automation-practice-form");

	    
		WebElement  fname=driver.findElement(By.id("firstName"));
		fname.sendKeys("Honda");
		WebElement  lname=driver.findElement(By.id("lastName"));
		lname.sendKeys("Bajaj");
		WebElement  email=driver.findElement(By.id("userEmail"));
		email.sendKeys("Bajaj@gmail.com");
		WebElement  gender=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[2]/label"));
		gender.click();
		WebElement  mob=driver.findElement(By.id("userNumber"));
		mob.sendKeys("12334556");
		WebElement  dob=driver.findElement(By.id("dateOfBirthInput"));
		dob.sendKeys("12 Mar 2020");
		dob.click();
		WebElement inputsubject=driver.findElement(By.id("subjectsInput"));
		//inputsubject.sendKeys("Maths");
		
		
		WebElement hobby=driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='hobbies-checkbox-2']"));
		hobby.click();
		WebElement pictureupload=driver.findElement(By.id("uploadPicture"));
		pictureupload.sendKeys("C:\\Users\\Hi\\Desktop\\download.jpg");
		WebElement addr=driver.findElement(By.id("currentAddress"));
		addr.sendKeys("xyz");
		//WebElement state=driver.findElement(By.xpath("//div[text()='Select State']"));
		//List<WebElement> states=driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[10]/div[2]/div/div/div[2]/div/svg/path"));
		//System.out.println(states.size());
		
		
	}
		
	}
	

