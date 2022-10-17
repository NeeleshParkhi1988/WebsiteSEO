package com.NOVO_SEO.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public WebDriver driver;
	public static String tsestName;
	public static String title;
	
	//Importing the Date util package
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static  String captureScreen(WebDriver driver, String title, String testName)
	{
		String path;
		
		try { 
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir")+"/ScreenShot/screenshots"+"_"+dateFormat2.format(date)+"/"+testName+"/"+title+"_"+dateFormat.format(date)+"_"+source.getName();
			FileUtils.copyFile(source, new File(path));
			Thread.sleep(1000);
		}catch (Exception e)
		{
			path = "Failed to capture the screenshot" + e.getMessage();
		}
		return path;
	}
	
	public static void cleanFolder(String testName)
	{
		try {
			File f = new File("./target/screenshots"+dateFormat2.format(date)+"/"+testName+"/");
			FileUtils.cleanDirectory(f);
			FileUtils.forceDelete(f);
			FileUtils.forceMkdir(f);
			System.out.println("Clean folder location....>>> " + f);	
		}catch(Exception e)
		{
			System.out.println("Location dose not exsist.....>>");
		}
	}
}
