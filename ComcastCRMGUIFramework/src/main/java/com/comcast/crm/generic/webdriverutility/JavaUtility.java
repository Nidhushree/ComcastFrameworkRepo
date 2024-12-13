package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random=new Random();
		int ranDomNumber = random.nextInt(5000);
		return ranDomNumber;
		}
	public String getSystemDateYYYYDDMM()
      {
		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
		}
	public String getRequiredDateYYYYDDMM(int days)
	{
		Date d1=new Date();
		/*SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
		String actDate1=sim1.format(d1); 
		Calendar cal = sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -30); //here we specify the format before or after 30 days
		 String dateRequires = sim1.format(cal.getTime());
		 return dateRequires;*/
	
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sim.format(d1); 
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days); 
		 String reqDate = sim.format(cal.getTime());
		 return reqDate;
	}
}

