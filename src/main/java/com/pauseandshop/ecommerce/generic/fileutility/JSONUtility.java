package com.pauseandshop.ecommerce.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	//JSON Obj is excatly similar to Hashmap
	public String getDataFromJSONFile(String Key) throws IOException, ParseException {
		FileReader filer= new FileReader("C:\\Users\\DELL\\eclipse-workspace\\SeleniumCRMFrameworkProj\\configAppdata\\appCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(filer);
		JSONObject map=(JSONObject)obj;
		String data=(String)map.get(Key);
		return data;
		
				
	}
	
	
}
