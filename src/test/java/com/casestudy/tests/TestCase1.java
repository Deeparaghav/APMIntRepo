package com.casestudy.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.casestudy.pom.BookingsPOM;
import com.casestudy.pom.LoginPOM;
import com.casestudy.pom.OrderingPOM;
import com.casestudy.utils.DriverFactory;
import com.casestudy.utils.DriverNames;


public class TestCase1 {

	private String baseUrl; 
	private LoginPOM loginPOM; 
	private BookingsPOM bookingPOM;
	private OrderingPOM orderingPOM;
	public static WebDriver driver; 		

	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"Auto01", "P@ss123","CN AS VDR","GB CUST01 HQ"},
			{"Auto02", "P@ss321","US ZY VDR","GB CUST02 HQ"}
		};
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.get("https://google.com");
		loginPOM = new LoginPOM(driver);	
			bookingPOM = new BookingsPOM(driver);
		orderingPOM = new OrderingPOM(driver);
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider="inputs")
	public void testMethod1(String userName, String password, String shippernumber, String consignee) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn(); 
		bookingPOM.ManualBooking();
		bookingPOM.search();
//		String randomnumber = String.valueOf(Math.random()*1000);
		int r = (int) (Math.random() * 500.0D);
        if (r <= 12345678) {
            r = 12345678;
            r = r + 1;
            System.out.println(r);
        }        
		bookingPOM.BookingNo(new CharSequence[] { String.valueOf(r) });
		String ponumber1 = "PO"+r;
		orderingPOM.ponumbertxt(ponumber1);
		orderingPOM.shippertxt(shippernumber);
		orderingPOM.consigneetxt(consignee);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Displaying current date in the desired format
		System.out.println("Current Date: "+sdf.format(cal.getTime()));
		//Number of Days to add
	     cal.add(Calendar.DAY_OF_MONTH, 3);  
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());  
		//Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: "+newDate);
		orderingPOM.etatxt1(newDate);
		orderingPOM.Savebtn();
		Alert alert = driver.switchTo().alert();
		String actualmessage = alert.getText();
		alert.accept();
		String expectedmessage = "Booking created successfully";
		
		if(expectedmessage.contains(actualmessage))
		{
			System.out.println("Booking created and test case passed successfully!!!!");
		}
		else
		{
			System.out.println("Test case failed");
		}
	
	}
}
