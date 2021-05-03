package TestCases_pom;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages_pom.HomePage;
import Pages_pom.LoginPage;
import Pages_pom.ProfilePage;
import Util_pom.Test_Utility;
import testbase_pom.TestBase;

public class ProfilePage_TestCases extends TestBase{
	
	LoginPage loginpage;
	
	HomePage homepage;
	
	ProfilePage profilepage;
	
	Test_Utility test_utility;
	
	String sheetname = "data";

	public ProfilePage_TestCases() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		
		inilization();
		
		loginpage = new LoginPage();
		
		homepage = loginpage.dologin(prop.getProperty("txt_email"), prop.getProperty("txt_pwd"));
		
		homepage = new HomePage();
		
        homepage.clickonaccountlist();

        homepage.clickonaddress();
		
		homepage.clickonaddaddress();
		
		test_utility = new Test_Utility();
		
		profilepage = new ProfilePage();
		
	}
	
	@Test(priority = 5)
	public void validatepagetitletest() {
		
		String actualpagetitle = profilepage.validatepagetitle();
		
		String expectedpagetitle = "Your Addresses";
		
		Assert.assertEquals(actualpagetitle, expectedpagetitle);
		
	}
	
	@DataProvider
	public Object [][] getTestdata() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		Object data[][] = Test_Utility.getTestData("sheetname");
		
		return data;
	
	}
	
	@Test(priority = 6, dataProvider ="getTestdata")
	public void getData(String country,String name,String phone,String pincode,String house,String street,String landmark,String town,String state,String addresstype) throws IOException, InterruptedException {
		
		profilepage.createnewaddress(country, name, phone, pincode, house, street, landmark, town, state, addresstype);
	
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
}
