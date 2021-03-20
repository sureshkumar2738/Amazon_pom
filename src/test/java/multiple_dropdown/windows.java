package multiple_dropdown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windows {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
     WebDriverManager.firefoxdriver().setup();
     
     driver = new FirefoxDriver();
     
     driver.get("https://www.bankofbaroda.in/");
     
     Thread.sleep(5000);
     
     Set<String> windid= driver.getWindowHandles();
     
     Iterator<String> myid = windid.iterator();
     
     driver.findElement(By.xpath("//section[@id='exclusiveOffers']//div[@class='socialFeedsInner']//div[@class='container']//ul[@class='socialFeedsList']//li//a[@class='btn insta'][contains(text(),'Instagram')]")).click();
     
     Thread.sleep(5000);
     
     windid = driver.getWindowHandles();
     
     myid = windid.iterator();
     
     String firstwindowid = myid.next();
     
     System.out.println("first windowid = "+firstwindowid);
     
     String secondwindowid = myid.next();
     
     System.out.println("second windowid = "+secondwindowid);
    
     driver.quit();
     
	}

}
