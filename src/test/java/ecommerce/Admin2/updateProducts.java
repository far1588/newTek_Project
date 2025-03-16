package ecommerce.Admin2;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pauseandshop.ecommerce.basetest.BaseClass;
import com.pauseandshop.ecommerce.generic.fileutility.ExcelUtility;
import com.pauseandshop.ecommerce.generic.fileutility.FileUtility;
import com.pauseandshop.ecommerce.generic.objectrepository.AdminLoginPage;
import com.pauseandshop.ecommerce.generic.objectrepository.HomePage;
import com.pauseandshop.ecommerce.generic.objectrepository.InsertProductPage;
import com.pauseandshop.ecommerce.generic.objectrepository.ManageProductsPage;
import com.pauseandshop.ecommerce.generic.objectrepository.SubCategoryPage;
import com.pauseandshop.ecommerce.generic.webdriverutility.UtilityClassObject;

@Listeners(com.pauseandshop.ecommerce.generic.listenerUtility.ListenerImp.class)
public class updateProducts extends BaseClass {
	@Test(groups = { "smokeTest", "regressionTest" })
	public void UpdateProducts() throws EncryptedDocumentException, IOException, InterruptedException {

		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productname = elib.getDataFromExcel("sheet1", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productname1 = elib.getDataFromExcel("sheet1", 4, 0);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productpricebefore1 = elib.getDataFromExcel("sheet1", 4, 4);

		ManageProductsPage mpp = new ManageProductsPage(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "click on manage btn");
		mpp.getManageprodbtn().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		mpp.getSearchtxt().sendKeys(productname);
		Thread.sleep(5000);

		UtilityClassObject.getTest().log(Status.INFO, "dynamically finding element");
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "click on edit btn");
		mpp.getEditbtn().click();
		Thread.sleep(1000);

		InsertProductPage ipp = new InsertProductPage(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "product name");
		WebElement pd = ipp.getInProdNameTxt();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "clear the txt");
		pd.clear();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		pd.sendKeys(productname1);
		Thread.sleep(1000);
		WebElement productpricee = ipp.getInProdPriceBfTxt();

		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "clear the txt");
		productpricee.clear();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send product price bf");
		productpricee.sendKeys(productpricebefore1);
		Thread.sleep(1000);
		WebElement submit = ipp.getInSubmitBtn();
		Actions a = new Actions(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "find submit button");
		a.moveToElement(submit).perform();
		UtilityClassObject.getTest().log(Status.INFO, "send enter robot key to click on submit btn");
		submit.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "click on manage btn");
		mpp.getManageprodbtn().click();
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		mpp.getSearchtxt().sendKeys(productname1);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO, "dynamically finding element");
		String actprod1 = driver.findElement(By.xpath("//td[text()='" + productname1 + "']")).getText();
		UtilityClassObject.getTest().log(Status.PASS, "verifying");
		Assert.assertEquals(true, actprod1.contains(productname1));

	}

	@Test(groups = { "smokeTest", "regressionTest" })
	public void DeleteProduct() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String InsertProd = elib.getDataFromExcel("sheet1", 1, 0);
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
		UtilityClassObject.getTest().log(Status.INFO, "click on insert btn");
		ipp.getInsertbtn().click();
		WebElement dropdowncat = ipp.getInsertDropdwn();
		UtilityClassObject.getTest().log(Status.INFO, "select by value in dropdown");
		wlib.selectByValue(dropdowncat, "3");

		WebElement dropdownsub = ipp.getInsertsubcatdropdown();
		UtilityClassObject.getTest().log(Status.INFO, "select by value in dropdown");
		wlib.selectByValue(dropdownsub, "8");
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		ipp.getInProdNameTxt().sendKeys(productname);
		UtilityClassObject.getTest().log(Status.INFO, "send product company name");
		ipp.getInProdComptxt().sendKeys(productcompany);
		UtilityClassObject.getTest().log(Status.INFO, "productpricebefore");
		ipp.getInProdPriceBfTxt().sendKeys(productpricebefore);
		UtilityClassObject.getTest().log(Status.INFO, "productpriceafter");
		ipp.getInProdPriceAfTxt().sendKeys(productpriceafter);
		UtilityClassObject.getTest().log(Status.INFO, "ProductDescription");

		ipp.getInProdDesTxt().sendKeys(ProductDescription);
		UtilityClassObject.getTest().log(Status.INFO, "ProductShippingCharge");
		ipp.getInProdShipChargesTxt().sendKeys(ProductShippingCharge);
		UtilityClassObject.getTest().log(Status.INFO, "Prod Available Dropdwn");

		WebElement productavailable = ipp.getInProdAvailableDropdwn();
		UtilityClassObject.getTest().log(Status.INFO, "productavailable");
		wlib.selectByValue(productavailable, "In Stock");
		UtilityClassObject.getTest().log(Status.INFO, "ProdImage1");
		WebElement choosefile1 = ipp.getInProdImage1();
		UtilityClassObject.getTest().log(Status.INFO, "address of the img");
		File fileupload = new File("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\harry.png");
		choosefile1.sendKeys(fileupload.getAbsolutePath());
		UtilityClassObject.getTest().log(Status.INFO, "ProdImage2");
		WebElement choosefile2 = ipp.getInProdImage2();
		UtilityClassObject.getTest().log(Status.INFO, "address of the img");
		File fileupload2 = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\harryyy.jpg");
		choosefile2.sendKeys(fileupload.getAbsolutePath());
		UtilityClassObject.getTest().log(Status.INFO, "ProdImage3");
		WebElement choosefile3 = ipp.getInProdImage3();
		UtilityClassObject.getTest().log(Status.INFO, "address of the img");
		File fileupload3 = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\image\\potter.jpg");
		choosefile3.sendKeys(fileupload.getAbsolutePath());
		UtilityClassObject.getTest().log(Status.INFO, "click on submit btn");
		ipp.getInSubmitBtn().sendKeys(Keys.ENTER);

		ManageProductsPage mpp = new ManageProductsPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "click on manage prod");
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		mpp.getSearchtxt().sendKeys(productname);
		UtilityClassObject.getTest().log(Status.INFO, "dynamically find element");
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();
		UtilityClassObject.getTest().log(Status.PASS, "verify");
		Assert.assertEquals(true, actprod.contains(productname));

		UtilityClassObject.getTest().log(Status.INFO, "click manage btn");
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		mpp.getSearchtxt().sendKeys(productname);
		UtilityClassObject.getTest().log(Status.INFO, "finding element dynamically");
		WebElement actprod1 = driver.findElement(By.xpath("//tr[td[text()='" + productname + "']]"));
		List<WebElement> deleteprod = mpp.getDeletebtn();
		UtilityClassObject.getTest().log(Status.PASS, "verify");
		Assert.assertEquals(true, !deleteprod.contains(productname));

	}

	@Test(groups = { "smokeTest", "regressionTest" })
	public void UpdateAndDelete() throws Throwable, IOException {
		String expectedtext = elib.getDataFromExcel("sheet1", 1, 1);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productpricebefore1 = elib.getDataFromExcel("sheet1", 4, 4);
		String productname1 = elib.getDataFromExcel("sheet1", 4, 0);
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String productname = elib.getDataFromExcel("sheet1", 1, 2);

		ManageProductsPage mpp = new ManageProductsPage(driver);
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "send productname");
		mpp.getSearchtxt().sendKeys(productname);
		UtilityClassObject.getTest().log(Status.INFO, "dynamically finding productname");
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();
		System.out.println(actprod);

		UtilityClassObject.getTest().log(Status.INFO, "dynamically finding productname");
		driver.findElement(By.xpath("//td[text()='" + productname + "']/../td/a[1]")).click();

		InsertProductPage ipp = new InsertProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "productname");
		WebElement pd = ipp.getInProdNameTxt();
		UtilityClassObject.getTest().log(Status.INFO, "clear txt");
		pd.clear();
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		pd.sendKeys(productname1);
		UtilityClassObject.getTest().log(Status.INFO, "product price bf txt");
		WebElement productpricee = ipp.getInProdPriceBfTxt();
		UtilityClassObject.getTest().log(Status.INFO, "clear");
		productpricee.clear();
		UtilityClassObject.getTest().log(Status.INFO, "productprice before1");
		productpricee.sendKeys(productpricebefore1);
		UtilityClassObject.getTest().log(Status.INFO, "submit");
		WebElement submit = ipp.getInSubmitBtn();

		Actions a = new Actions(driver);
		UtilityClassObject.getTest().log(Status.INFO, "submit");
		a.moveToElement(submit).perform();
		UtilityClassObject.getTest().log(Status.INFO, "sending enter keys to submit btn");
		submit.sendKeys(Keys.ENTER);
		UtilityClassObject.getTest().log(Status.INFO, "click on manage btn");
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "send productname");
		mpp.getSearchtxt().sendKeys(productname1);
		UtilityClassObject.getTest().log(Status.INFO, "dynamically finding element");
		String actprod1 = driver.findElement(By.xpath("//td[text()='" + productname1 + "']")).getText();
		UtilityClassObject.getTest().log(Status.PASS, "verify");
		Assert.assertEquals(true, actprod1.contains(productname1));

		UtilityClassObject.getTest().log(Status.INFO, "click on manage product btn");
		mpp.getManageprodbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on search btn");
		WebElement search1 = mpp.getSearchtxt();
		UtilityClassObject.getTest().log(Status.INFO, "send product name");
		search1.sendKeys(productname1);

		UtilityClassObject.getTest().log(Status.INFO, "dynamically sending product name");
		WebElement actprod11 = driver.findElement(By.xpath("//tr[td[text()='" + productname1 + "']]"));
		UtilityClassObject.getTest().log(Status.INFO, "delete btn");
		List<WebElement> deleteprod = mpp.getDeletebtn();
		UtilityClassObject.getTest().log(Status.PASS, "verify");
		Assert.assertEquals(true, !deleteprod.contains(productname1));

	}

	@Test
	public void SubCatDropdown() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "getting data from excel");
		String SubCat = elib.getDataFromExcel("sheet1", 1, 0);
		SubCategoryPage scp = new SubCategoryPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "click on subcat");
		scp.getSubcatbtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "subcat");
		WebElement dropdown = scp.getSubCatdropdown();
		UtilityClassObject.getTest().log(Status.INFO, "select dropdown");
		wlib.selectByValue(dropdown, "3");
		UtilityClassObject.getTest().log(Status.INFO, "get text subcat");
		String actsubcat = scp.getActsubcatverify().getText();
		UtilityClassObject.getTest().log(Status.PASS, "verify");
		Assert.assertEquals(true, actsubcat.contains(SubCat));

	}

}
