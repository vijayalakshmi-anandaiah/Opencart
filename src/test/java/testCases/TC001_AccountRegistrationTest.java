package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.TestContext;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Master"})
	public void verify_Account_Registration() throws InterruptedException
	{	
		logger.info("*****Starting TC001_AccountRegistrationTest*****"); //Log Statements/Comments
		
		try{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();																	
																							
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);  
		
		String email = randomString() + "@gmail.com";
		String password = randomAlphaNumeric();
		String firstName = randomString();
		String lastName = randomString();
		String phone = randomNumber();
		
		TestContext.email = email;
		TestContext.password = password;
		TestContext.firstName = firstName;
		TestContext.lastName = lastName;
		
		arp.setFirstName(firstName);
		arp.setLastName(lastName);
		arp.setEmail(email);
		arp.setTelphone(phone);
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		arp.chkprivacybtn();
		arp.clckcontinuebtn();
		
		//CAPTURING CONFIRMATION MESSAGE	
		String confmsg =arp.getConfirmationMsg();
		
		//VALIDATION OF CONFIRMATION MESSAGE
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("TestCase Failed");
			logger.debug("Debug Logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		 logger.info("*** Finished TC001_AccountRegistrationTest ***");	
	}

	private String randomAlphaNumeric() {
		@SuppressWarnings("deprecation")
		String generatedAlpNum = RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(3);
		return generatedAlpNum;
	}

	private String randomString() {
		@SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	private String randomNumber() {
		@SuppressWarnings("deprecation")
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	
}

