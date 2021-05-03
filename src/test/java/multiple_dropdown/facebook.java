package multiple_dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@id='u_0_2']")).click();
		
		Thread.sleep(5000);
		
		//WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		//WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		//List<WebElement> dropdownoptions = day.findElements(By.tagName("option"));
		//List<WebElement> dropdownoptions = month.findElements(By.tagName("option"));
		List<WebElement> dropdownoptions = year.findElements(By.tagName("option"));
		
		System.out.println("total number of options =" +dropdownoptions.size());
		
		System.out.println(dropdownoptions.get(1).getText());
		
		for (int i=0;i<dropdownoptions.size();i++) {
			
			System.out.println(i+"."+dropdownoptions.get(i).getText());
			
		}
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
