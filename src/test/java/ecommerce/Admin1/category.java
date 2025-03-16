package ecommerce.Admin1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.pauseandshop.ecommerce.basetest.BaseClass;
import com.pauseandshop.ecommerce.generic.fileutility.ExcelUtility;
import com.pauseandshop.ecommerce.generic.fileutility.FileUtility;
import com.pauseandshop.ecommerce.generic.objectrepository.AdminLoginPage;
import com.pauseandshop.ecommerce.generic.objectrepository.CreateCategoryPage;
import com.pauseandshop.ecommerce.generic.objectrepository.HomePage;
import com.pauseandshop.ecommerce.generic.objectrepository.InsertProductPage;
import com.pauseandshop.ecommerce.generic.objectrepository.ManageProductsPage;
import com.pauseandshop.ecommerce.generic.objectrepository.SubCategoryPage;
import com.pauseandshop.ecommerce.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pauseandshop.ecommerce.generic.listenerUtility.ListenerImp.class)
public class category extends BaseClass {
	@Test(groups = "regressionTest")

	public void Category() throws EncryptedDocumentException, IOException, InterruptedException {

		// read test script data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String cat = elib.getDataFromExcel("sheet1", 4, 2);
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String catdes = elib.getDataFromExcel("sheet1", 4, 3);
		Thread.sleep(1000);

		UtilityClassObject.getTest().log(Status.INFO, "clicking on category button");
		CreateCategoryPage ccp = new CreateCategoryPage(driver);
		Thread.sleep(1000);
		ccp.getCategorybtn().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "sending category name to textbox");
		ccp.getCattxt().sendKeys(cat);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "sending category description");
		ccp.getCatDescriptiontxt().sendKeys(catdes);
		UtilityClassObject.getTest().log(Status.INFO, "click on submit button");
		ccp.getCatsubmitbtn().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "sending category name to txtbx");
		ccp.getCatSearchbtn().sendKeys(cat);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "finding category name dynamically");
		String actcat = driver.findElement(By.xpath("//td[text()='" + cat + "']")).getText();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.PASS, "verifying the category name");
		Assert.assertEquals(true, actcat.contains(cat));

	}

	@Test(groups = "regressionTest")
	public void InsertProdDetails() throws EncryptedDocumentException, Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productname = elib.getDataFromExcel("sheet1", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productcompany = elib.getDataFromExcel("sheet1", 1, 3);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productpricebefore = elib.getDataFromExcel("sheet1", 1, 4);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productpriceafter = elib.getDataFromExcel("sheet1", 1, 5);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String ProductDescription = elib.getDataFromExcel("sheet1", 1, 6);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String ProductShippingCharge = elib.getDataFromExcel("sheet1", 1, 7);

		// insert product
		InsertProductPage ipp = new InsertProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "clicking on insertbtn");
		ipp.getInsertbtn().click();
		Thread.sleep(1000);

		WebElement dropdowncat = ipp.getInsertDropdwn();
		UtilityClassObject.getTest().log(Status.INFO, "select dropdown option");
		wlib.selectByValue(dropdowncat, "3");
		Thread.sleep(1000);
		WebElement dropdownsub = ipp.getInsertsubcatdropdown();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "select dropdown option");
		wlib.selectByValue(dropdowncat, "8");
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send productname");
		ipp.getInProdNameTxt().sendKeys(productname);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send productcompany name");
		ipp.getInProdComptxt().sendKeys(productcompany);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send productprice before ");
		ipp.getInProdPriceBfTxt().sendKeys(productpricebefore);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send productprice after ");
		ipp.getInProdPriceAfTxt().sendKeys(productpriceafter);

		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send Product Description ");
		ipp.getInProdDesTxt().sendKeys(ProductDescription);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "ProductShippingCharge ");
		ipp.getInProdShipChargesTxt().sendKeys(ProductShippingCharge);
		Thread.sleep(1000);
		WebElement productavailable = ipp.getInProdAvailableDropdwn();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "productavailable ");
		wlib.selectByValue(productavailable, "In Stock");
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send InProdImage1 ");
		WebElement choosefile1 = ipp.getInProdImage1();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send image address ");
		File fileupload = new File("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\harry.png");
		choosefile1.sendKeys(fileupload.getAbsolutePath());
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send InProdImage2 ");
		WebElement choosefile2 = ipp.getInProdImage2();
		UtilityClassObject.getTest().log(Status.INFO, "send image address ");
		File fileupload2 = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\harryyy.jpg");
		choosefile2.sendKeys(fileupload.getAbsolutePath());
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send InProdImage3 ");
		WebElement choosefile3 = ipp.getInProdImage3();
		UtilityClassObject.getTest().log(Status.INFO, "send image address ");
		File fileupload3 = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\potter.jpg");
		choosefile3.sendKeys(fileupload.getAbsolutePath());
		UtilityClassObject.getTest().log(Status.INFO, "click on submit btn ");
		ipp.getInSubmitBtn().sendKeys(Keys.ENTER);

		ManageProductsPage mpp = new ManageProductsPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "click on manage btn");
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "search btn ");
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		UtilityClassObject.getTest().log(Status.INFO, "send Product naem");
		search.sendKeys(productname);
		UtilityClassObject.getTest().log(Status.INFO, "search dynamically productname");
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "verify ");
		Assert.assertEquals(true, actprod.contains(productname));

	}

	@Test(groups = "regressionTest")
	public void Subcategory() throws EncryptedDocumentException, IOException, InterruptedException {

		String subcat = elib.getDataFromExcel("sheet1", 4, 1);
		UtilityClassObject.getTest().log(Status.INFO, "waiting to page to load");
		wlib.waitForPageToLoad(driver);
		SubCategoryPage scp = new SubCategoryPage(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "click on subcatbtn ");
		scp.getSubcatbtn().click();
		Thread.sleep(1000);
		WebElement dropdownsub = scp.getSubCatdropdown();
		UtilityClassObject.getTest().log(Status.INFO, "select the dropdown option ");
		wlib.selectByValue(dropdownsub, "3");
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send subcat name ");
		scp.getSubcatnametxt().sendKeys(subcat);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "click on save btn");
		scp.getSavebtn().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send subcat in searchbtn ");
		scp.getSearchbtn().sendKeys(subcat);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "dynamically search subcat name ");
		String actsub = driver.findElement(By.xpath("//td[text()='" + subcat + "']")).getText();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.PASS, "verify subcat name");
		Assert.assertEquals(true, actsub.contains(subcat));

	}

	@Test(groups = "smokeTest")
	public void InsertProductSelectOneDropdown() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String InsertProd = elib.getDataFromExcel("sheet1", 1, 0);

		// insert product
		InsertProductPage ipp = new InsertProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "click on insertbtn");
		ipp.getInsertbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on dropdonw");
		WebElement dropdown = ipp.getInsertDropdwn();
		UtilityClassObject.getTest().log(Status.INFO, "select dropdown option");
		wlib.selectByValue(dropdown, "3");
		UtilityClassObject.getTest().log(Status.INFO, "get insertproduct name");
		String actInsertProd = ipp.getVerifyinserttxt().getText();
		UtilityClassObject.getTest().log(Status.PASS, "verifying insertproduct name");
		Assert.assertEquals(true, actInsertProd.contains(InsertProd));

	}
}
