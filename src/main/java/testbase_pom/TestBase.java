package testbase_pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Util_pom.Test_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	public static File file;
	
	public static FileInputStream fis;
	
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Properties_pom\\config.properties");
		
		fis = new FileInputStream(file);
		
		prop = new Properties();
		
		prop.load(fis);
		
	}
	
	public static void inilization() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
			
		}
		
		else {
			
			System.out.println("selenium doesnot support this browser = "+browsername);
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Test_Utility.IMPLICTWAITTIMEOUT,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Test_Utility.PAGELOADTIMEOUT, TimeUnit.SECONDS);
	}
	
}
