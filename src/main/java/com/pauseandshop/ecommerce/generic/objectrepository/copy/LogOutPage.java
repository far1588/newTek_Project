package com.pauseandshop.ecommerce.generic.objectrepository.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;
	public LogOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
}
