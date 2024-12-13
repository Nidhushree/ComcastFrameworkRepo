package practice.testNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.asserts.SoftAssert.*;

import org.testng.Assert;

public class AssertinValidation {
	
	@Test
	
	public void assertEqualCheck()
	{
		System.out.println("------L1------");
		System.out.println("-----L2-------");
		Assert.assertEquals("a", "b");
		System.out.println("------L3");
		System.out.println("------L4");
	}   //not execute L3 and L4
	
	@Test
	
	public void softAssert() 
	{
		System.out.println("------H1----");
		System.out.println("------H2----");
		SoftAssert s=new SoftAssert();
		s.assertEquals("A", "b");
		System.out.println("------H3----");
		
		System.out.println("------H4----");
		s.assertAll();
		
	}

}
