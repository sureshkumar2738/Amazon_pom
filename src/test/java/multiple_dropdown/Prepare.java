package multiple_dropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prepare {

	public static WebDriver driver;
	public static String url = "https://www.leafground.com/dashboard.xhtml";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			driver.get(url);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@class='pi pi-globe layout-menuitem-icon']")).click();
			
			driver.findElement(By.xpath("//*[@class='pi pi-fw pi-stop layout-menuitem-icon']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame(0);
			//driver.findElement(By.xpath("//*[contains(text(),' Click Me (Inside frame)')]/following-sibling::iframe")).click();
			driver.findElement(By.xpath("//*[@style='color:#ffffff;background: linear-gradient(240deg, #ff7295 0%, #fe875d 100%);border: 0 none;width:15%;height:40%']")).click();
			
			driver.switchTo().parentFrame();
			System.out.println(driver.getTitle());
			driver.switchTo().frame("frame2");
			driver.findElement(By.xpath("//*[@style='background: linear-gradient(240deg, #4b7ecf 0%, #8e70ee 100%); color:#ffffff;border: 0 none;width:15%;height:40%']")).click();
			
			driver.findElement(By.xpath("//*[contains(text(),'Count Frames')]")).click();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			driver.quit();
		}
	}

}
