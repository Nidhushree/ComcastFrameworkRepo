package practice.testNG;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void createOrderTest()
	{
		System.out.println("Execute createOrderTest===>123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void billingAnOrderTest()
	{
		System.out.println("Execute billingorderTest===>123");
	}

}
