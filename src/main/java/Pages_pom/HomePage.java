package Pages_pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase_pom.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-belt']/div[1]/div[1]/a[1]/span[1]")
	WebElement logo;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement accountlist;
	
	@FindBy(xpath = "//span[contains(text(),'Your Account')]")
	WebElement youraccount;
	
	@FindBy(xpath = "//h2[contains(text(),'Your Addresses')]")
    WebElement  address;
	
	@FindBy(xpath = "//h2[contains(text(),'Add address')]")
	WebElement addaddress;
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

    public String Validatepagetitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean Validatelogo() {
		
		return logo.isDisplayed();
		
	}
	
	public ProfilePage clickonaccountlist() throws IOException, InterruptedException {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(accountlist).build().perform();
		Thread.sleep(3000);
		
		youraccount.click();
		
		Thread.sleep(5000);
		
		return new ProfilePage();
		
	}
	
	public ProfilePage clickonaddress() throws IOException, InterruptedException {
		
		address.click();
		
		Thread.sleep(5000);
		
		return new ProfilePage();
		
	}
	
    public ProfilePage clickonaddaddress() throws IOException, InterruptedException {
		
		addaddress.click();
		
		Thread.sleep(5000);
		
		return new ProfilePage();
		
	}

}