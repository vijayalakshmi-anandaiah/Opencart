package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC005_PrdctDscptnTest extends BaseClass {
	
	@Test(groups={"Sanity"})
	public void verifyPrdctDscptnPage() {
		
		logger.info("******** Starting TC005_ProductDescriptionTest ********");
		
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
		
		ProductDescriptionPage pd=new ProductDescriptionPage(driver);
		pd.selectColor();
		pd.clickOnAddToCart();
		pd.clickOnCart();
		pd.clickOnViewCart();
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC005_ProductDescriptionTest ********");
	}

}
