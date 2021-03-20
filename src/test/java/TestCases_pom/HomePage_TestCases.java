package TestCases_pom;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages_pom.HomePage;
import Pages_pom.LoginPage;
import Pages_pom.ProfilePage;
import testbase_pom.TestBase;

public class HomePage_TestCases extends TestBase{
	
	LoginPage loginpage;
	
	HomePage homepage;
	
	ProfilePage profilepage;

	public HomePage_TestCases() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		
		inilization();
		
		loginpage = new LoginPage();
		
		homepage = loginpage.dologin(prop.getProperty("txt_email"), prop.getProperty("txt_pwd"));
		
		homepage = new HomePage();
		
	}
	
	@Test(priority = 2)
	public void homepagevalidatepagetitletest() {
		
		String actualpagetitle = homepage.Validatepagetitle();
		
		Assert.assertEquals(actualpagetitle, "Your Amazon.in");
		
	}
	
	@Test(priority = 3)
	public void homepagevalidatelogo() {
		
		boolean flag = homepage.Validatelogo();
		
		Assert.assertTrue(flag,"logo is missing");
		
	}
	
	@Test(priority = 4)
	public void verifyaccountlisttest() throws IOException, InterruptedException {
		
		homepage.clickonaccountlist();
		
		homepage.clickonaddress();
		
		homepage.clickonaddaddress();
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
}
