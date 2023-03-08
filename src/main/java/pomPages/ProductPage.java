package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[text()='add to cart']")
	private WebElement addtocart;
	
	@FindBy(id="cart_fl")
	private WebElement cart;
	
	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getCart() {
		return cart;
	}

	
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
		//PageFactory.initElements(driver, this);
		//this.driver=driver;
	}
	
	public CartPage addtocartbtn() {
		addtocart.click();
		cart.click();
		return new CartPage(driver);
	}
	
	

}
