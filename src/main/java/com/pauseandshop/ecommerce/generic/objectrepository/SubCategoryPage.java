package com.pauseandshop.ecommerce.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
	WebDriver driver;
	public SubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
	@FindBy(xpath = "//a[@href='subcategory.php']")
	private WebElement Subcatbtn;
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement SubCatdropdown;
	
	@FindBy(xpath = "//option[@value='3']")
	private WebElement actsubcatverify;
	
	@FindBy(xpath = "//input[@class='span8 tip']")
	private WebElement subcatnametxt;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchbtn;
	
	
	
	public WebElement getSubcatnametxt() {
		return subcatnametxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public WebElement getActsubcatverify() {
		return actsubcatverify;
	}


	public WebElement getSubcatbtn() {
		return Subcatbtn;
	}

	
	public WebElement getSubCatdropdown() {
		return SubCatdropdown;
	}
	
}
