package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HeaderSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC004_ProductPageTest extends BaseClass {

	@Test(groups={"Sanity"})
	public void verifyProductPage() {
		
		logger.info("******** Starting TC004_ProductPageTest ********");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(TestContext.email);
		lp.setPassword(TestContext.password);
		lp.clickLoginBtn();
		
		HeaderSection hs=new HeaderSection(driver);
		hs.clickCameraLink();
	
		ProductPage pp=new ProductPage(driver);
		pp.clickOnSelectedProduct();
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC004_ProductPageTest ********");
	}
}
