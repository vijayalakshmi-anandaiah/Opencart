package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	
	public ProductPage (WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'Canon EOS 5D')]")
	WebElement product_selection;
	
	public void clickOnSelectedProduct(){
		product_selection.click();
	}

}
