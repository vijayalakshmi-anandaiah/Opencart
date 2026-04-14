package testCases;

/*
If Data is Valid-- Login Successful-- Test passed-- Logout
					Login Unsuccessful-- Test Failed
					
If Data is Invalid-- Login Success-- Test Failed-- Logout
					  Login Failed--- Test passed
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC008_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven") //getting data provider from different class/package
	public void verify_LoginDDT(String email, String pwd, String exp_result)
	{
		logger.info("***Starting TC008_LoginDataDrivenTest***");
	try {	
	//HomePage		
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	//Login
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLoginBtn();
	
	//MyAccountPage
	MyAccountPage myacc=new MyAccountPage(driver);
	boolean targetPage =myacc.isMyAccountPageExists();
	
	if(exp_result.equalsIgnoreCase("VALID"))  //if data is valid
	{
		if(targetPage==true) 				//Login successful
		{
			myacc.clickLogout();		//LogOut
			Assert.assertTrue(true);	//Testcase passed
		}
		else 
		{
			Assert.assertTrue(false); //else testcase failed
		}
	}
	
	if(exp_result.equalsIgnoreCase("INVALID"))  //If data is invalid
	{
		if(targetPage==true)   //Login successful
		{
			myacc.clickLogout();   	//Logout
			Assert.assertTrue(false);  //Testcase Failed
		}
		else 							//else testcase passed
		{
			Assert.assertTrue(true);
		}
	}	
	}catch(Exception e) 
	{
		Assert.fail();
	}
	logger.info("***Finished TC008_LoginDataDrivenTest***");
}
}
