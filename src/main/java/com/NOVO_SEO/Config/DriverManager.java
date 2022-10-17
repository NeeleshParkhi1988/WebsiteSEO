
package com.NOVO_SEO.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.NOVO_SEO.ExcelReader.excelReader;

public class DriverManager {
	
	protected static WebDriver driver;
	public static Properties prop;
	excelReader excel;
	
	public static WebDriver getDriver(String browser) throws IOException
	{
		Properties prop = new Properties();
		String ConfigfilePath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\TruBIDatamatics\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(ConfigfilePath);
		prop.load(fis);
		
		System.out.println(browser);
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\WebDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We dont support This Browser.");
		}
		return driver;
	}
	
	//Excel Reader Method
	public String[][] getData(String ExcelName , String sheetName)
	{
		String path = System.getProperty("user.dir")+"src/main/java/com/TruBIDatamatics/resources" + ExcelName;
		excel = new excelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
		return data;
	}

}
