package com.pauseandshop.ecommerce.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath ="//a[@href='admin']")
	private WebElement adminlink;
	
	public WebElement getAdminlink() {
		return adminlink;
	}
	@FindBy(xpath = "(//a[@href='logout.php'])[2]")
	private WebElement logout;

	public void url(String URL) {
		driver.get(URL);
	}
	
	public WebElement getLogout() {
		return logout;
	}
	public void login(String URL) {
		driver.get(URL);
		adminlink.click();
		
	}

	public void logout() {
		logout.click();
	}

}
