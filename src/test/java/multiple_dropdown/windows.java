package multiple_dropdown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windows {

	public static WebDriver driver;
	public static String url = "https://www.bankofbaroda.in/";
	
	public static void main(String[] args) throws InterruptedException {
	
     WebDriverManager.chromedriver().setup();
     
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     
     try {
    	 
		driver.get(url);
		 
		 Thread.sleep(5000);
		 
		 Set<String> windid= driver.getWindowHandles();
		 
		 Iterator<String> myid = windid.iterator();
		 
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,6000)");
			
		 driver.findElement(By.xpath("//*[@aria-label='Facebook']")).click();
		 
		 Thread.sleep(5000);
		 
		 windid = driver.getWindowHandles();
		 
		 myid = windid.iterator();
		 
		 String firstwindowid = myid.next();
		 
		 System.out.println("first windowid = "+firstwindowid);
		 
		 String secondwindowid = myid.next();
		 
		 System.out.println("second windowid = "+secondwindowid);
	
     } catch (InterruptedException e) {
		
		driver.quit();
	}  
	}
}
