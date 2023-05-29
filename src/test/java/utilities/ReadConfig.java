package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	private static Properties pro;
	
	public static void readconfig () {
		File src = new File ("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
			
		}
	
	public static final String EXCEL = "./Data Files/SalesforceLMSData.xlsx";
	
	public static String getBrowser() {
		String browser =  pro.getProperty("browser");
		if (browser != null)
		return browser;
		else 
			throw new RuntimeException("Browser Not Specified in Config.Properties file");
		}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseurl");
		return url;
	}
}
