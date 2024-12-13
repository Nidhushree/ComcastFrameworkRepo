package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName, String lastName)
	{
		System.out.println(" firstName: "+firstName+ ", lastName: "+lastName);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];  //3 indicate number  of times and 2 indicates number of arguments
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		//objArr[0][2]="9900112255l";
		
		objArr[1][0]="sam";
		objArr[1][1]="sh";
		//objArr[0][2]="9900112266l";
		
		objArr[2][0]="John";
		objArr[2][1]="smith";
		//objArr[0][2]="9900112266l";
		return objArr;
	}

}
