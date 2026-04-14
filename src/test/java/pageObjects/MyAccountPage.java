package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement HeadingMsg;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")WebElement logoutelmnt;
	
	//We cannot perform validation in POC's
	
	public boolean isMyAccountPageExists()
	{
		try {
			return(HeadingMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogout() {
		logoutelmnt.click();
	}

}
