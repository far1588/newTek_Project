package com.pauseandshop.ecommerce.basetest;

import java.io.IOException;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import com.pauseandshop.ecommerce.generic.databaseutility.DataBaseUtility;
import com.pauseandshop.ecommerce.generic.fileutility.ExcelUtility;
import com.pauseandshop.ecommerce.generic.fileutility.FileUtility;
import com.pauseandshop.ecommerce.generic.fileutility.JSONUtility;
import com.pauseandshop.ecommerce.generic.objectrepository.AdminLoginPage;
import com.pauseandshop.ecommerce.generic.objectrepository.HomePage;
import com.pauseandshop.ecommerce.generic.webdriverutility.JavaUtility;
import com.pauseandshop.ecommerce.generic.webdriverutility.UtilityClassObject;
import com.pauseandshop.ecommerce.generic.webdriverutility.WebDriverUtility;



public class BaseClass {
	UtilityClassObject ulib=new UtilityClassObject();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JSONUtility jsLib=new JSONUtility();
	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public  static WebDriver sdriver;
	public  WebDriver driver;

	
@BeforeSuite(groups= {"smokeTest","regressionTest"})
public void configBS() throws SQLException {
	System.out.println("==connect to DB, Report config==");
	dbLib.getDbconnection();
}

@BeforeClass(groups= {"smokeTest","regressionTest"})
public void configBC() throws IOException {
	System.out.println("==Launch the Browser==");
	String Browser=flib.getDataFromPropertiesFile("browser");
	
	if(Browser.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (Browser.equals("firefox")) {
		driver = new FirefoxDriver();
	} else {
		driver = new ChromeDriver();
	}
	sdriver=driver;
	UtilityClassObject.setDriver(driver);
	}

@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void configBM() throws IOException {
	System.out.println("==login==");
//	String Browser = flib.getDataFromPropertiesFile("browser");
	String URL = flib.getDataFromPropertiesFile("url");
	String Username = flib.getDataFromPropertiesFile("username");
	String Password = flib.getDataFromPropertiesFile("password");
	AdminLoginPage lp=new AdminLoginPage(driver);
	lp.Login(URL, Username, Password);
}
@AfterMethod(groups= {"smokeTest","regressionTest"})
public void configAM() {
	System.out.println("==logout==");
	 HomePage hp=new  HomePage(driver);
	 hp.logout();
}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void configAC() {
	System.out.println("==close the browser==");
	driver.quit();
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void configAS() {
	System.out.println("==closeDB,report backup==");
	dbLib.closeDbConnection();
	
}
}


