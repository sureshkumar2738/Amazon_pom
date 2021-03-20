package multiple_dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wikipedia {

	public static WebDriver driver;
	
	public static String url = "https://www.wikipedia.org/";
	
	public static void main(String[] args) throws InterruptedException {
		
    WebDriverManager.firefoxdriver().setup();
    
    driver = new FirefoxDriver();
    
    driver.get(url);
    
    Thread.sleep(5000);
    
    WebElement lang = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
    
    List<WebElement> dropdownoptions = lang.findElements(By.tagName("option"));
    
    System.out.println("total dropdownoptions = "+dropdownoptions.size());
    
    System.out.println(dropdownoptions.get(6).getText());
    
    for(int i=0;i<dropdownoptions.size();i++) {
    	
    	System.out.println(i+"."+dropdownoptions.get(i).getText());
    }
    
    driver.quit();
    
	}

}
