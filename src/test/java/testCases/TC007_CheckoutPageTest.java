package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HeaderSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC007_CheckoutPageTest extends BaseClass {

	@Test(groups = { "Smoke", "Regression" })
	public void verifyCheckoutPage() throws InterruptedException {

		logger.info("******** Starting TC007_CheckoutPageTest ********");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LOGIN PAGE
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(TestContext.email);
			lp.setPassword(TestContext.password);
			lp.clickLoginBtn();

			// HEADER SECTION

			HeaderSection hs = new HeaderSection(driver);
			hs.clickCameraLink();

			// PRODUCT PAGE
			ProductPage pp = new ProductPage(driver);
			pp.clickOnSelectedProduct();

			// PRODUCT DESCRIPTION PAGE
			ProductDescriptionPage pd = new ProductDescriptionPage(driver);
			pd.selectColor();
			pd.clickOnAddToCart();
			pd.clickOnCart();
			Thread.sleep(2000);
			pd.clickOnViewCart();

			// SHOPPING CART
			ShoppingCartPage sc = new ShoppingCartPage(driver);
			sc.shippingTaxesDrpdwn();
			sc.selectCountry();
			sc.selectState();
			sc.enterPostalCode();
			sc.clickBtn();
			sc.clickRadioBtn();
			sc.clickOnShpngBtn();
			Thread.sleep(2000);
			sc.clickOnChkoutBtn();

			// CHECKOUT PAGE
			CheckoutPage cp = new CheckoutPage(driver);
			cp.setFirstName(TestContext.firstName);
			cp.setLastName(TestContext.lastName);
			cp.setAddress("Banaswadi");
			cp.setCity("Bangalore");
			cp.setPostalCode("15693");
			cp.selectCountry();
			cp.selectState();
			cp.clickOnPymntAddrBtn();
			cp.clickOnShpngAddrContinueBtn();
			cp.insertComment("Im out of town on delivery date so please call me once the product is OUT FOR DELIVERY");
			cp.clickOnShpngMthdContinueBtn();
			cp.clickOnTC();
			cp.clickOnPymntMthdContinueBtn();
			cp.clickOnConfirmOrder();
		} 
		catch (

		Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC007_CheckoutPageTest ********");
	}
}
