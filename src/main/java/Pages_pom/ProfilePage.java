package Pages_pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testbase_pom.TestBase;

public class ProfilePage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId_101\"]")
	WebElement country;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement code;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement house;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement street;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-landmark']")
	WebElement landmark;
	
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement town;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_1\"]")
	WebElement state;
	
	@FindBy(xpath = "//*[@id=\"dropdown1_1\"]")
	WebElement addresstype;
	
	public ProfilePage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validatepagetitle() {
		
		return driver.getTitle();
		
	}
		
	public void createnewaddress(String cntry,String nme,String phne,String cde,String hose,String stret,String lndmrk,String twn,String stat,String addaddresstpe) throws InterruptedException {
		
		Select select = new Select(country);
		select.selectByVisibleText(cntry);
		
		name.sendKeys(nme);
		Thread.sleep(2000);
		
		phone.sendKeys(phne);
		
		code.sendKeys(cde);
		Thread.sleep(2000);
		
		house.sendKeys(hose);
		
		street.sendKeys(stret);
		Thread.sleep(2000);
		
		landmark.sendKeys(lndmrk);
		
		town.sendKeys(twn);
		Thread.sleep(2000);
		
		Select select1 = new Select(state);
		select1.selectByVisibleText(stat);
		
		Select select2 = new Select(addresstype);
		select2.selectByVisibleText(addaddresstpe);
		Thread.sleep(2000);
			
		WebElement Addaddressbtn = driver.findElement(By.xpath("//*[@id=\\\"address-ui-widgets-form-submit-button\\\"]/span/input"));
		
		Addaddressbtn.click();
		
	}
		
	}

