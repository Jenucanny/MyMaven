package SeleniumProgram;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
@BeforeSuite
public void beforeSuite() {
	System.out.println("Functonal Suite");
}
@BeforeTest
public void beforeTest()
{
	System.out.println("DB Connection Established");
}
@BeforeMethod
public void beforeMethod()
{
	System.out.println("Browser Launched");
}
@AfterMethod
public void afterMethod()
{
	System.out.println("Browser Closed");
}
@AfterSuite
public void afterSuite()
{
System.out.println("Functional Suite End!!");	
}
@AfterTest
public void afterTest()
{
	System.out.println("DB connection closed");
}
@Test(priority=1)
public void verifyLogin()
{
	System.out.println("Testcase for Login Verification");
Assert.assertEquals("a", "a","Mismatch");	
}
@Test(priority=2)
public void verifyTitle()
{
	System.out.println("Testcase for title verification");
Assert.assertEquals("a", "a","Mismatch");	
}
@Test(priority=3)
public void verifyDropdown()
{
	System.out.println("Dropdown verified");
}
}
