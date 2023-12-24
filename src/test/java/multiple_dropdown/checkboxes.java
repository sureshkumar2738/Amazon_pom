package multiple_dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxes {

	public static WebDriver driver;
	
	public static String url = "http://www.tizag.com/htmlT/htmlcheckboxes.php";
	
	public static void main(String[] args) throws InterruptedException {
		
      WebDriverManager.chromedriver().setup();
      
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      
      driver.get(url);
      
      JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		
      List<WebElement> checkboxes = driver.findElements(By.name("sports"));
      
      System.out.println("total checkboxes = "+checkboxes.size());
      
      checkboxes.get(2).click();
      
      System.out.println(checkboxes.get(2).getAttribute("value"));
      System.out.println(checkboxes.get(2).getAttribute("checked"));
      
      driver.quit();
	}

}
