package Demo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListCompare {
	@Test
	public void main()
	{
List<String> expectedList=new ArrayList<String>();
expectedList.add("hi");
expectedList.add("hello");
List<String> actualList=new ArrayList<String>();
actualList.add("hi");
actualList.add("hello");
if(actualList.size()==expectedList.size())
{
for(int i=0;i<expectedList.size();i++)
{
	String actualTxt=actualList.get(i);
	String expectedTxt=expectedList.get(i);
	Assert.assertEquals(actualTxt,expectedTxt,"Failed!!!");
}
}
System.out.println("Size Differs!!");
	}
}
