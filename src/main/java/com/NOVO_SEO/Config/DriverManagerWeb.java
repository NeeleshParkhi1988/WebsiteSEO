
package com.NOVO_SEO.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.NOVO_SEO.ExcelReader.excelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerWeb {

	protected static WebDriver driver;
	public static Properties prop;
	public static Properties verifyprop;
	excelReader excel;

	@BeforeMethod
	public static WebDriver getDriver() throws IOException {

		// Introducing the config properties file into the project
		prop = new Properties();
		String configfilepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NOVO_SEO\\Resources\\config.properties";
		FileInputStream fis = new FileInputStream(configfilepath);
		prop.load(fis);

		verifyprop = new Properties();
		String verifyfilepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NOVO_SEO\\Resources\\verify.properties";
		FileInputStream fis1 = new FileInputStream(verifyfilepath);
		prop.load(fis1);

		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);

		// Applying different browsers conditions as per the requirement
		// Chrome Browser Invoke
		if (BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// For Running Driver into headless mode
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (BrowserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("We Don't Support This Browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}

	@AfterMethod
	public void driverquit() {
		driver.quit();
	}

	// Excel Reader Method
	public String[][] getData(String ExcelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/TruBIDatamatics/resources/" + ExcelName;
		excel = new excelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
		return data;
	}

}
