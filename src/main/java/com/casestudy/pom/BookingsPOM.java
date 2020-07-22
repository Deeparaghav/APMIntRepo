package com.casestudy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingsPOM {
	
	private WebDriver driver;
	
	public BookingsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="CreateManualBooking")
	private WebElement manualBooking; 
	
	@FindBy(id="Search")
	private WebElement search;
	
	@FindBy(id="BookingNo")
	private WebElement bookingNo;
	
	public void ManualBooking() {
		this.manualBooking.click();
	}
	
	public void search() {
		this.search.click();
	}
	
	public void BookingNo(CharSequence[] r) {
		this.bookingNo.clear();
		this.bookingNo.sendKeys(r);
	}
	
}
