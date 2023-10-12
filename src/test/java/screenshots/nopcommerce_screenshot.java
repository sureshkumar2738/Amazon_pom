package screenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nopcommerce_screenshot {

	public static String url = "https://www.nopcommerce.com/en/demo";
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println(System.getProperty("user.dir"));
		
    WebDriverManager.chromedriver().setup();
    
    driver = new ChromeDriver();
    
    driver.get(url);
    
    Thread.sleep(5000);
    
    screenshhot(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot_nop"+
    GetCurrentTimeStamp().replace(".","_").replace(":","_")+".jpg"); 
    
    driver.quit();
    
	}


    public static void screenshhot(String path) throws IOException

    {

File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshotFile, new File(path));

    }
    
    public static String GetCurrentTimeStamp()
    
    {
    	
    	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
    	
    	Date now = new Date();
    	
    	String strdate = sdfDate.format(now);
    	
		return strdate;
    	
    }
    
}
