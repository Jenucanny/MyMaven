package Demo;

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

public class TypesAlertHandle {
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
@Test(enabled=false)
public void simpleAlert()
{
	driver.get("https://demoqa.com/alerts");
	WebElement simple=driver.findElement(By.id("alertButton"));
	simple.click();
	Alert alert=driver.switchTo().alert();
	String actualText=alert.getText();
	String expectedText="You clicked a button";
	Assert.assertEquals(actualText, expectedText, "Errror!! Mismatch");
	alert.accept();
}
@Test(enabled=false)
public void confirmationAlert() throws InterruptedException
{
	driver.get("https://demoqa.com/alerts");
	WebElement confirm=driver.findElement(By.id("confirmButton"));
	confirm.click();
	Alert alert=driver.switchTo().alert();
	String actualText=alert.getText();
	String expectedText="Do you confirm action?";
	Assert.assertEquals(actualText, expectedText, "Eror!! Text Mismatch");
	//alert.accept();
	Thread.sleep(3000);
	alert.dismiss();
	
	
}
@Test(enabled=true)
public void promptAlert() throws InterruptedException
{
	driver.get("https://demoqa.com/alerts");
	WebElement prompt=driver.findElement(By.id("promtButton"));
	prompt.click();
	Alert alert=driver.switchTo().alert();
	String actualText=alert.getText();
	String expectedText="Please enter your name";
	Assert.assertEquals(actualText, expectedText, "Error!! Text Mismatch");
	alert.sendKeys("Drogo");
	Thread.sleep(3000);
	alert.accept();
	//alert.dismiss();
}



}

	

