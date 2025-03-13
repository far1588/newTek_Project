package com.pauseandshop.ecommerce.generic.objectrepository.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	WebDriver driver;
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
	@FindBy(id= "inputEmail")
	private WebElement AdminUNTxt;
	
	@FindBy(id="inputPassword")
	private WebElement AdminPwdTxt;
	
	@FindBy(name="submit")
	private WebElement AdminLoginBtn;
	
	@FindBy(xpath ="//a[@href='admin']")
	private WebElement adminlink;

	public WebElement getAdminUNTxt() {
		return AdminUNTxt;
	}

	
	public WebElement getAdminPwdTxt() {
		return AdminPwdTxt;
	}

	
	public WebElement getAdminLoginBtn() {
		return AdminLoginBtn;
	}
	
	public void Login(String URL,String Username,String Password) {
		driver.get(URL);
		adminlink.click();
		AdminUNTxt.sendKeys(Username);
		AdminPwdTxt.sendKeys(Password);
		AdminLoginBtn.click();
	}


	public WebElement getAdminlink() {
		return adminlink;
	}
}
