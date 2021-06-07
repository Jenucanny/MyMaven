package SeleniumProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionCmd {
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
	@Test(enabled=false)
	public void doubleClick()
	{
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclk=driver.findElement(By.xpath("//button[text()=\"Double-Click Me To See Alert\"]"));
		Actions action=new Actions(driver);
		action.doubleClick(doubleclk).build().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
	@Test(enabled=false)
	public void rightClk()
	{
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement rtclk=driver.findElement(By.xpath("//span[text()=\"right click me\"]"));
		Actions action=new Actions(driver);
		action.contextClick(rtclk).build().perform();
	}
	@Test(enabled=false)
	public void mouseOver()
	{
		driver.get("https://demoqa.com/menu/");
		List<WebElement> mainItem1=driver.findElements(By.xpath("//ul[@id='nav']/li/a"));
		for(int i=0;i<mainItem1.size();i++)
		{
			
			String mainItem1Elements=mainItem1.get(i).getText();
			if(mainItem1Elements.equalsIgnoreCase("Main Item 1"))
			{
				Actions action=new Actions(driver);

              // action.moveToElement(mainItem1.get(i)).build().perform();
				action.moveToElement(mainItem1.get(i),100,100).build().perform();
			}
		}
		
	}@Test(enabled=false)
	public void dragdrop()
	{
		driver.get("https://demoqa.com/droppable");
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		action.dragAndDrop(drag, drop);
				
	}
	@Test(enabled=false)
	public void dragAndDropByOffset()
	{
	driver.get("https://demoqa.com/dragabble");	
	WebElement drag=driver.findElement(By.id("dragBox"));
	Actions action=new Actions(driver);
	//action.dragAndDropBy(drag, 100, 100).build().perform();
	action.clickAndHold(drag).dragAndDropBy(drag, 100, 100).build().perform();
		}
	@Test(enabled=false)
	public void mainItem2HW()
	{
		driver.get("https://demoqa.com/menu/");
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);  //page load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //implicit wait
		List<WebElement> mainItems=driver.findElements(By.xpath("//ul[@id='nav']/li/a"));
		for(int i=0;i<mainItems.size();i++)
		{
			String mainItemtxt=mainItems.get(i).getText();
			if(mainItemtxt.equalsIgnoreCase("Main Item 2"))
			{
				Actions action=new Actions(driver);
				action.moveToElement(mainItems.get(i)).build().perform();
				List<WebElement> sublist=driver.findElements(By.tagName("a"));
				for(int j=0;j<sublist.size();j++)
				{
					String subtxt=sublist.get(j).getText();
					//System.out.println(subtxt);
					if(subtxt.equalsIgnoreCase("SUB SUB LIST »"))
					{
						
						action.moveToElement(sublist.get(j)).build().perform();
						List<WebElement> subsub2=driver.findElements(By.tagName("a"));
						for(int k=0;k<subsub2.size();k++)
						{
							String susbsub2txt=subsub2.get(k).getText();
							if(susbsub2txt.equalsIgnoreCase("Sub Sub Item 2"))
							{
								action.moveToElement(subsub2.get(k)).build().perform();
							}
							
							
						}
					}
					
				}
			}
			
		}
	}
	@Test
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
	if(tableHead.size()==tableHead.size())
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
	
}
