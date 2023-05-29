package baseclass;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig config;
	String br;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public WebDriver initializeWebdriver(String browser)throws  Exception {
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {
			throw new RuntimeException("BrowserType Not Supported");

		}
		      //Setting implicit wait
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				driver.manage().window().maximize();
				
				//Setting WebDriverWait with max timeout value of 20 seconds
				wait =new WebDriverWait(driver,Duration.ofSeconds(20));
				return driver;

		
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeallDriver() {
		//driver.close();
	}
	
	
	public static Map<String,String> getDataFromExcel(String SheetName, int Rownumber) throws InvalidFormatException, IOException  {
		ExcelReader excelReader = new ExcelReader();
		Map<String,String> Data = 
				excelReader.getData(ReadConfig.EXCEL, SheetName).get(Rownumber);
		return Data;
	}
	
}
