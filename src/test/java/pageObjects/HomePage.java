package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//CONSTRUCTOR
	
	public HomePage (WebDriver driver){
		
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccountlnk;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Registerlnk;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Loginlnk;
	
	
	//Action Methods

	public void clickMyAccount() 
	{
		MyAccountlnk.click();
	}
	
	public void clickRegister() 
	{
		Registerlnk.click();
	}
	
	public void clickLogin() 
	{
		Loginlnk.click();
	}
	
	
}
