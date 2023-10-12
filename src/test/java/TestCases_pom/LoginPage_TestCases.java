package TestCases_pom;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages_pom.HomePage;
import Pages_pom.LoginPage;
import testbase_pom.TestBase;

public class LoginPage_TestCases extends TestBase{

	LoginPage loginpage;
	
	HomePage homepage;
	
	public LoginPage_TestCases() throws IOException {
		super();
	
	}

	@BeforeMethod
	public void setup() throws IOException {
		
		inilization();
		
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void dologin() throws IOException, InterruptedException {
		
		homepage = loginpage.dologin(prop.getProperty("txt_email"), prop.getProperty("txt_pwd"));
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
}

