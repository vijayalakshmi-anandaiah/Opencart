package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
//CONSTRUCTOR
	
	public LoginPage(WebDriver driver)
	{
		super(driver);	
	}
	
//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_add;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd1;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
//Action Methods
	
	public boolean isLoginPageDisplayed() {
	    return driver.getTitle().contains("Account Login");
	}
	
	public void setEmail(String e_add)
	{
	email_add.sendKeys(e_add);	
	}
	
	public boolean isEmailFieldDisplayed() 
	{
		return email_add.isDisplayed();
	}
	
	public void setPassword(String s_pwd) 
	{
	pwd1.sendKeys(s_pwd);
	}
	
	public boolean isLoginButtonEnabled() {
	    return loginbtn.isEnabled();
	}
	
	public void clickLoginBtn()
	{
	loginbtn.click();	
	}
	
	
	
}
