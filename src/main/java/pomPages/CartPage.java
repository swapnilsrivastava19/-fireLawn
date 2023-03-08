package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Buy Now']")
	private WebElement buy;
	
	public CartPage(WebDriver driver) {
super (driver);	
		
		//	PageFactory.initElements(driver, this);
	//	this.driver=driver;
	}
	
	public AddressPage buynow() {
		buy.click();
		return new AddressPage(driver);
	}

}
