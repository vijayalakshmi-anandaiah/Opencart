package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HeaderSection extends BasePage {
	
	public HeaderSection(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Cameras']")
	WebElement lnkCameras;
	
	public void clickCameraLink() {
		lnkCameras.click();
	}
		
}








