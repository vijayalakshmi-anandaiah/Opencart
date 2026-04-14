package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends BasePage {
	
	public ProductDescriptionPage (WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//select[@id='input-option226']")
	WebElement dropdownclr;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnadd2cart;
	
	@FindBy(xpath="//button[.//span[@id='cart-total']]")
	WebElement btncart;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement viewcart;
	
	public void selectColor() {
	    Select s = new Select(dropdownclr);
	    s.selectByVisibleText("Blue");
	}
	
	public void clickOnAddToCart() {
		btnadd2cart.click();
	}
	
	public void clickOnCart() {
		btncart.click();
	}
	
	public void clickOnViewCart() {
		viewcart.click();
	}
}
