package com.pauseandshop.ecommerce.generic.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {
	WebDriver driver;
	public ManageProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="//a[@href='manage-products.php']")
	private WebElement Manageprodbtn;
	
	@FindBy(xpath="//a[@href='edit-products.php?id=13']']")
	private WebElement ManageEditeBtn;
	
	@FindBy(xpath = "//div[@class='module-head']")
	private WebElement ManageInsertEditBtn;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchtxt;
	
	@FindBy(xpath = "//i[@class='icon-edit']")
	private WebElement editbtn;
	
	

	

	public List<WebElement> getDeletebtn() {
		return deletebtn;
	}
	
@FindBy(xpath = "//i[@class='icon-remove-sign']")
private List<WebElement> deletebtn;
	
	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getManageprodbtn() {
		return Manageprodbtn;
	}


	public WebElement getManageEditeBtn() {
		return ManageEditeBtn;
	}

	
	public WebElement getManageInsertEditBtn() {
		return ManageInsertEditBtn;
	}
}
