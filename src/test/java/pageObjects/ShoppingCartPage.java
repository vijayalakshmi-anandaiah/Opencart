package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='quantity[8]']")
	WebElement qnty;

	@FindBy(xpath = "//a[normalize-space()='Estimate Shipping & Taxes']")
	WebElement shpngtaxsdrpdwn;

	@FindBy(xpath = "//select[@id='input-country']")
	WebElement drpdwncountry;

	@FindBy(xpath = "//select[@id='input-zone']")
	WebElement drpdwnstate;

	@FindBy(xpath = "//input[contains(@placeholder,'Post Code')]")
	WebElement postcode;

	@FindBy(xpath = "//button[@id='button-quote']")
	WebElement btnquotes;

	@FindBy(xpath = "//input[@name='shipping_method']")
	WebElement btnradio;

	@FindBy(xpath = "//input[@id='button-shipping']")
	WebElement btnshipping;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement chkoutbtn;

	public void shippingTaxesDrpdwn() {
		shpngtaxsdrpdwn.click();
	}

	public void selectCountry() {
		Select s1 = new Select(drpdwncountry);
		s1.selectByVisibleText("India");
	}

	public void selectState() {
		Select s2 = new Select(drpdwnstate);
		s2.selectByVisibleText("Karnataka");
	}

	public void enterPostalCode() {
		postcode.sendKeys("123456");
	}

	public void clickBtn() {
		btnquotes.click();
	}

	public void clickRadioBtn() {
		btnradio.click();
	}

	public void clickOnShpngBtn() {
		btnshipping.click();
	}

	public void clickOnChkoutBtn() {
		chkoutbtn.click();
	}

}
