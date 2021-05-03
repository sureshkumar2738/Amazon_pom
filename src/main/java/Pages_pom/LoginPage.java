package Pages_pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase_pom.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id = "ap_email")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement ctnuebtn;
	
	@FindBy(id = "ap_password")
	WebElement txt_pwd;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement lgnbtn;

	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public HomePage dologin(String em,String pwd) throws IOException, InterruptedException {
		
		txt_email.click();
		txt_email.sendKeys(em);
		
		Thread.sleep(3000);
		ctnuebtn.click();
		
		txt_pwd.click();
		txt_pwd.sendKeys(pwd);
		
		Thread.sleep(3000);
		lgnbtn.click();
		
		Thread.sleep(9000);
		
		return new HomePage();
		
	}

}
