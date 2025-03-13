package com.pauseandshop.ecommerce.generic.objectrepository.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {
	WebDriver driver;
	public InsertProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath = "//a[text()='Insert Product ']")
	private WebElement Insertbtn;
	
	@FindBy(xpath = "(//select[@class='span8 tip'])[1]")
	private WebElement InsertDropdwn;
	
	@FindBy(xpath = "//option[@value='3']")
	private WebElement verifyinserttxt;
	
	@FindBy(id="subcategory")
	private WebElement Insertsubcatdropdown;
	
	@FindBy(name="productName")
	private WebElement InProdNameTxt;
	
	@FindBy(name="productCompany")
	private WebElement InProdComptxt;
	
	@FindBy(name="productpricebd")
	private WebElement InProdPriceBfTxt;
	
	@FindBy(name="productprice")
	private WebElement InProdPriceAfTxt;
	
	@FindBy(xpath = "//div[@class=' nicEdit-main']")
	private WebElement InProdDesTxt;
	
	@FindBy(name="productShippingcharge")
	private WebElement InProdShipChargesTxt;
	
	@FindBy(id="productAvailability")
	private WebElement InProdAvailableDropdwn;
	
	@FindBy(xpath = "//input[@id='productimage1']")
	private WebElement InProdImage1;
	
	@FindBy(name="productimage2")
	private WebElement InProdImage2;
	
	@FindBy(name="productimage3")
	private WebElement InProdImage3;
	
	@FindBy(xpath = "//button[@class='btn']")
	private WebElement InSubmitBtn;
	

	public WebElement getInSubmitBtn() {
		return InSubmitBtn;
	}

	public WebElement getInProdNameTxt() {
		return InProdNameTxt;
	}

	public WebElement getInProdComptxt() {
		return InProdComptxt;
	}

	public WebElement getInProdPriceBfTxt() {
		return InProdPriceBfTxt;
	}

	public WebElement getInProdPriceAfTxt() {
		return InProdPriceAfTxt;
	}


	public WebElement getInProdDesTxt() {
		return InProdDesTxt;
	}


	public WebElement getInProdShipChargesTxt() {
		return InProdShipChargesTxt;
	}

	public WebElement getInProdAvailableDropdwn() {
		return InProdAvailableDropdwn;
	}


	public WebElement getInProdImage1() {
		return InProdImage1;
	}


	public WebElement getInProdImage2() {
		return InProdImage2;
	}


	public WebElement getInProdImage3() {
		return InProdImage3;
	}


	public WebElement getInsertsubcatdropdown() {
		return Insertsubcatdropdown;
	}


	public WebElement getInsertDropdwn() {
		return InsertDropdwn;
	}
	
	
	public WebElement getVerifyinserttxt() {
		return verifyinserttxt;
	} 
	public WebElement getInsertbtn() {
		return Insertbtn;
	}
	public void prodName(String productname1) {
		InProdNameTxt.clear();
		InProdNameTxt.sendKeys(productname1);
		
	}
}
