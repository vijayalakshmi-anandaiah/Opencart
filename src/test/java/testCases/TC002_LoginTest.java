package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Smoke","Regession" })
	public void verify_loginPage() {
		logger.info("**Starting TC002_LoginTest**");

		// HomePage
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			// LoginPage

			LoginPage lp = new LoginPage(driver);

			Assert.assertTrue(lp.isLoginPageDisplayed(), "Login Page is not displayed");
			Assert.assertTrue(lp.isEmailFieldDisplayed(), "Email field is not displayed");
			
			lp.setEmail(TestContext.email);
			lp.setPassword(TestContext.password);			

/*	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));	
*/
			Assert.assertTrue(lp.isLoginButtonEnabled(), "Login button is disabled");
			lp.clickLoginBtn();

			// MyAccountPage
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage = myacc.isMyAccountPageExists();
			Assert.assertTrue(targetPage); // or Assert.assertEquals(targetPage, true, "Login failed");

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**Finished TC002_LoginTest**");
	}

}
