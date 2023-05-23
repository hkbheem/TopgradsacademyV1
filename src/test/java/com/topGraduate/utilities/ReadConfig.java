package com.topGraduate.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("Configurations/config.properties");
		
		try {
		
		FileInputStream fis = new FileInputStream(src);
		
		prop = new Properties();
		
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
			
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getEUsername()
	{
		String username=prop.getProperty("eUsername");
		return username;
	}
	
	public String getEPassword()
	{
		String username=prop.getProperty("ePassword");
		return username;
	}


}
