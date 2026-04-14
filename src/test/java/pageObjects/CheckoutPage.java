package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-payment-firstname']")WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")WebElement LastName;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")WebElement Address;
	
	@FindBy(xpath="//input[@id='input-payment-city']")WebElement City;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")WebElement PostCode;
	
	@FindBy(xpath="//select[@id='input-payment-country']")WebElement Country;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")WebElement State;
	
	@FindBy(xpath="//input[@id='button-payment-address']")WebElement Continue1; 
	
	@FindBy(xpath="//input[@id='button-shipping-address']")WebElement Continue2;
	
	@FindBy(xpath="//textarea[@name='comment']")WebElement Comment;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")WebElement Continue3; 
	
	@FindBy(xpath="//input[@name='agree']")WebElement TCs;
	
	@FindBy(xpath="//input[@id='button-payment-method']")WebElement Continue4;
	
	@FindBy(xpath="//input[@id='button-confirm']")WebElement ConfirmOrder;
	
	
	public void setFirstName(String fName) {
		FirstName.sendKeys("fname");	
	}
	public void setLastName(String lName) {
		LastName.sendKeys(lName);
	}
	public void setAddress(String addrs) {
		Address.sendKeys(addrs);
	}
	public void setCity(String cty) {
		City.sendKeys(cty);
	}
	public void setPostalCode(String pstcd) {
		PostCode.sendKeys(pstcd);
	}
	public void selectCountry() {
	    Select s3 = new Select(Country);
	    s3.selectByVisibleText("India");
	}
	public void selectState() {
	    Select s4 = new Select(State);
	    s4.selectByVisibleText("Karnataka");
	}
	public void clickOnPymntAddrBtn() {
		Continue1.click();
	}
	public void clickOnShpngAddrContinueBtn() {
		Continue2.click();
	}
	public void insertComment(String comnt) {
		Comment.sendKeys(comnt);
	}
	public void clickOnShpngMthdContinueBtn() {
		Continue3.click();
	}
	public void clickOnTC() {
		TCs.click();
	}
	public void clickOnPymntMthdContinueBtn() {
		Continue4.click();
	}
	public void clickOnConfirmOrder() {
		ConfirmOrder.click();
	}
}
