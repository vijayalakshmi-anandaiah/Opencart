package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC003_HeaderTest extends BaseClass {
	
	@Test(groups={"Sanity"})
	public void verifyHeaderSection() {
		
		logger.info("Starting Header Section Verification");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(TestContext.email);
		lp.setPassword(TestContext.password);
		lp.clickLoginBtn();
	
		
		HeaderSection hs=new HeaderSection(driver);
		Thread.sleep(1000);
		hs.clickCameraLink();
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******** Finished Header Section Verification ********");
	}			
}
