package practice.testNG;

import org.testng.annotations.Test;

public class CreateContactTest {
	
	@Test
	public void createContactTest() {
		System.out.println("execute create contact");
	}
	

	@Test(dependsOnMethods="createContactTest")
	public void modifyContactTest() {
		System.out.println("execute modifycontact");
	}
	
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest() {
		System.out.println("execute deletecontact");
	}

}
