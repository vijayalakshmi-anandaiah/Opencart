package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	// CONSTRUCTOR

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// LOCATORS

	@FindBy(name = "firstname")
	WebElement frstname;

	@FindBy(id = "input-lastname")
	WebElement lstname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement e_mail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telnum;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpwd;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement subscribebtn;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkButton;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// ACTION METHODS

	public void setFirstName(String fname) {
		frstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lstname.sendKeys(lname);
	}

	public void setEmail(String email) {
		e_mail.sendKeys(email);
	}

	public void setTelphone(String randomNumber) {
		telnum.sendKeys(randomNumber);
	}

	public void setPassword(String passwd) {
		pwd.sendKeys(passwd);
	}

	public void setConfirmPassword(String cpasswd) {
		confirmpwd.sendKeys(cpasswd);
	}

	public void chkprivacybtn() {
		checkButton.click();
	}

	public void clckcontinuebtn() {
		continuebtn.click();
	}

	public String getConfirmationMsg() {

		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	
}