package com.pauseandshop.ecommerce.generic.objectrepository.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	WebDriver driver;
	public CreateCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
	@FindBy(xpath = "//a[@href='category.php']")
	private WebElement Categorybtn;
	
	@FindBy(name="category")
	private WebElement Cattxt;
	
	@FindBy(name="description")
	private WebElement CatDescriptiontxt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement Catsubmitbtn;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement CatSearchbtn;
	
	
	public WebElement getCatSearchbtn() {
		return CatSearchbtn;
	}


	public WebElement getCategorybtn() {
		return Categorybtn;
	}

	
	public WebElement getCattxt() {
		return Cattxt;
	}


	public WebElement getCatDescriptiontxt() {
		return CatDescriptiontxt;
	}

	
	public WebElement getCatsubmitbtn() {
		return Catsubmitbtn;
	}

	
	
}
