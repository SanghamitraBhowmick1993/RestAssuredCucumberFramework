package com.sfdc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider(){
		try{
			File src = new File("./Config/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	public String getBrowser(){
		return prop.getProperty("Browser");
	}
	public String getURL(){
		return prop.getProperty("qaURL");
	}
}
