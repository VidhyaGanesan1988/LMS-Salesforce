package baseclass;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ReadConfig;

public class Hooks {
	
	public static WebDriver driver;
	private static BaseClass baseclass;
	
	@Before
	public static void launchbrowser()  throws Throwable {
		//Get Browser Type
		ReadConfig.readconfig();
		String browser = ReadConfig.getBrowser();
		
		//Initialze driver from baseclass
		baseclass = new BaseClass();
		driver = baseclass.initializeWebdriver(browser);
		
	}
	@After
	public static void after() throws InterruptedException {
		BaseClass.closeallDriver();
}
}
