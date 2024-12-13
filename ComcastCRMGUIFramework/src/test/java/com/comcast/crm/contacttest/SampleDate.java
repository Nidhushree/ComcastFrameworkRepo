package com.comcast.crm.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SampleDate {

	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d);   // it gives the current date and time
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sim.format(d);   //it gives date for specific format
		System.out.println("Actual Date " +actDate);
		
		Date d1=new Date();
		SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
		String actDate1=sim1.format(d1); 
		Calendar cal = sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -30); //here we specify the format before or after 30 days
		 String dateRequires = sim1.format(cal.getTime());
		 System.out.println( "Before Date: "+dateRequires);
		 
		 
		

	}

}
