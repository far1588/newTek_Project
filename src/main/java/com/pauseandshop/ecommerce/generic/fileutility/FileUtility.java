package com.pauseandshop.ecommerce.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String Key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p =new Properties();
		p.load(fis);
		String data=p.getProperty(Key);
		return data;
	}

	
	
}
