package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	public WebDriver driver;
	
	@FindBy(id="search")
	private WebElement searchtb;
	
	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	@FindBy(id="search_prod")
	private WebElement searchbtn;
	
	public HomePage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		//this.driver=driver;
	}
	
	public Product searchelement(String productname) {
		searchtb.sendKeys(productname);
		searchbtn.click();
		return new Product(driver);
		
	}

}
