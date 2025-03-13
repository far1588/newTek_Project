package com.pauseandshop.ecommerce.generic.objectrepository.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
		
		
		
		
}
