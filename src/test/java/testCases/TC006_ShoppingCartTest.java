package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC006_ShoppingCartTest extends BaseClass {

	@Test(groups={"Sanity"})
	public void verifyShoppingCart() throws InterruptedException {
		
		logger.info("******** Starting TC006_ShoppingCartTest ********");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LOGIN PAGE
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(TestContext.email);
		lp.setPassword(TestContext.password);
		lp.clickLoginBtn();
		
		//HEADER SECTION
		HeaderSection hs=new HeaderSection(driver);
		Thread.sleep(1000);		
		hs.clickCameraLink();
		
		//PRODUCT PAGE
		ProductPage pp=new ProductPage(driver);
		pp.clickOnSelectedProduct();
		
		//PRODUCT DESCRIPTION PAGE
		ProductDescriptionPage pd=new ProductDescriptionPage(driver);
		pd.selectColor();
		pd.clickOnAddToCart();
		pd.clickOnCart();
		pd.clickOnViewCart();
		
		//SHOPPING CART PAGE
		ShoppingCartPage sc= new ShoppingCartPage(driver);
		sc.shippingTaxesDrpdwn();
		sc.selectCountry();
		sc.selectState();
		sc.enterPostalCode();
		sc.clickBtn();
		sc.clickRadioBtn();
		sc.clickOnShpngBtn();
		Thread.sleep(2000);
		sc.clickOnChkoutBtn();
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		 logger.info("******** Finished TC006_ShoppingCartTest ********");
	}
	
	}
