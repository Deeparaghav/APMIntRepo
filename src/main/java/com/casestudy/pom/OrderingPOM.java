package com.casestudy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderingPOM {
	private WebDriver driver;
	
	public OrderingPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="PONumber")
	private WebElement ponumber; 
	
	@FindBy(id="Shipper")
	private WebElement shipper;
	
	@FindBy(id="Consignee")
	private WebElement consignee;
	
	@FindBy(id="ETA")
	private WebElement eta;
	
	@FindBy(id="Save")
	private WebElement save;
	
	@FindBy(id="Msg")
	private WebElement msg;
	
	@FindBy(id="BookingNo")
	private WebElement bookingNo;
	
	

	
	public void ponumbertxt(String ponumber1) {
		this.ponumber.clear();
		this.ponumber.sendKeys(ponumber1);
	}
	
	public void shippertxt(String shippertxt) {
		this.shipper.clear();
		this.shipper.sendKeys(shippertxt);
	}
	
	public void consigneetxt(String consigneetxt) {
		this.bookingNo.clear();
		this.bookingNo.sendKeys(consigneetxt);
	}
	
	public void etatxt1(String etadate) {
		this.bookingNo.clear();
		this.bookingNo.sendKeys(etadate);
	}
	
	public void Savebtn() {
		this.bookingNo.click();
	}
		
	
	public void msgpopup() {
		this.msg.click();
	}
	
	public String confbookingnumber() {
		return this.bookingNo.getText();
	}
	
}
