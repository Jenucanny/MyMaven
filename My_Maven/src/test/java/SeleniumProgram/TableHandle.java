package SeleniumProgram;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableHandle {
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
	public void handlingTable()
	{
	driver.get("http://demo.guru99.com/test/web-table-element.php#");	
	List<WebElement> tableHead=driver.findElements(By.xpath("//table[@class='dataTable']//th"));
	List<String> expected=new ArrayList<String>();
	expected.add("Company");
	expected.add("Group");
	expected.add("Prev Close (Rs)");
	expected.add("Current Price (Rs)");
	expected.add("% Change");
	System.out.println(expected.size());
	if(tableHead.size()==expected.size())
	{
	for(int i=0;i<tableHead.size();i++)
	{
		//System.out.println(tableHead.get(i).getText());
		String expectedTxt=expected.get(i);
		String actualTxt=tableHead.get(i).getText();
		
		Assert.assertEquals(actualTxt,expectedTxt,"Mismatch!!");
	}
	}
	else 
		System.out.println("Size Differs!!!");
	}
	@Test(enabled=false)
	public void handleTableHW()
	{
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> tableHead=driver.findElements(By.xpath("//table[@id='customers']//th"));
		List<String> expectedHead=new ArrayList<String>();
		expectedHead.add("Company");
		expectedHead.add("Contact");
		expectedHead.add("Country");
		if(tableHead.size()==expectedHead.size())
		{
			for(int i=0;i<tableHead.size();i++)
			{
				String expectedHeadTxt=expectedHead.get(i);
				String actualTxt=tableHead.get(i).getText();
				Assert.assertEquals(actualTxt,expectedHeadTxt,"Mismatch!!");
				
			}
		}
		else
			System.out.println("Size Differs!!!");
		
		
	}
	@Test(enabled=false)
	public void handleTableHWrow()
	{
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> tablerow3=driver.findElements(By.xpath("//table[@id='customers']//tr[3]/td"));
		List<String> expectedRow=new ArrayList<String>();
		expectedRow.add("Centro comercial Moctezuma");
		expectedRow.add("Francisco Chang");
		expectedRow.add("Mexico");
		//System.out.println(tablerow3.size());
		if(tablerow3.size()==expectedRow.size())
		{
			for(int i=0;i<tablerow3.size();i++)
			{
				
				String expectedTxt=expectedRow.get(i);
				String actualTxt=tablerow3.get(i).getText();
				System.out.println(actualTxt);
				Assert.assertEquals(actualTxt,expectedTxt,"Mismatch!!");
				
			}
		}
		else
			System.out.println("Size Differs!!!");	
		
	}
	@Test(enabled=false)
	public void handleTableHWrow5()
	{
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> tablerow5=driver.findElements(By.xpath("//table[@id='customers']//tr[5]/td"));
		List<String> expectedRow5=new ArrayList<String>();
		expectedRow5.add("Island Trading");
		expectedRow5.add("Helen Bennett");
		expectedRow5.add("UK");
		//System.out.println(tablerow3.size());
		if(tablerow5.size()==expectedRow5.size())
		{
			for(int i=0;i<tablerow5.size();i++)
			{
				
				String expectedTxt=expectedRow5.get(i);
				String actualTxt=tablerow5.get(i).getText();
				System.out.println(actualTxt);
				Assert.assertEquals(actualTxt,expectedTxt,"Mismatch!!");
				
			}
		}
		else
			System.out.println("Size Differs!!!");	
		
		
	}
	@Test(enabled=false)
	public void robotClass() throws AWTException, InterruptedException
	{
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
		register.click();
		Robot robot=new Robot();
		WebElement firstName=driver.findElement(By.name("firstName"));
		firstName.sendKeys("Tom");
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_DELETE);
		//robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		
	}
	@Test(enabled=false)
	public void javaScriptExecut()
	{
		driver.get("http://demowebshop.tricentis.com/login");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('Email').value='123'");
		js.executeScript("document.getElementById('newsletter-subscribe-button').click()");
		//js.executeScript("window.scrollBy(0,1000)"); //scroll (window)
		
	}
	
	@Test(enabled=true)
	public void contactdisplay()
	{
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> tabledata=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		//System.out.println(tabledata.size());
		for(int i=2;i<tabledata.size();i++)
		{
			List<WebElement> expectedrow=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td"));
			
			for(int j=0;j<expectedrow.size();j++) {
			if(expectedrow.get(j).getText().equalsIgnoreCase("Island Trading"))
			{
				for(int k=1;k<expectedrow.size();k++)
				{
				System.out.println(expectedrow.get(k).getText());
				
			}
			}
		}
		
	}
}
}
