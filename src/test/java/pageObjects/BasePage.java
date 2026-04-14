package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver; // Variable

	public BasePage(WebDriver driver) { // Constructor;parent of all POC'S i.e BasePage is extended in all POC's

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
