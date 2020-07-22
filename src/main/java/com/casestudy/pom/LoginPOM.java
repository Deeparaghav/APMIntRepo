package com.casestudy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement userId; 
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="Login")
	private WebElement loginBtn; 
	
	public void sendUserName(String userId) {
		this.userId.clear();
		this.userId.sendKeys(userId);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

}
