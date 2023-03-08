package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {
	
	// public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Add New Address']")
	private WebElement addaddress;
	
	@FindBy(id="outlined-size-small")
	private WebElement nametb;
	
	@FindBy(id="outlined-size-small")
	private WebElement house;
	
	@FindBy(id="outlined-size-small")
	private WebElement street;
	
	@FindBy(id="outlined-size-small")
	private WebElement landmark;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddaddress() {
		return addaddress;
	}

	public WebElement getNametb() {
		return nametb;
	}

	public WebElement getHouse() {
		return house;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getLandmark() {
		return landmark;
	}

	public WebElement getCountrydd() {
		return countrydd;
	}

	public WebElement getStatedd() {
		return statedd;
	}

	public WebElement getCitydd() {
		return citydd;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getPhonenum() {
		return phonenum;
	}

	public WebElement getAddressradio() {
		return addressradio;
	}

	public WebElement getProceesbtn() {
		return proceesbtn;
	}

	@FindBy(id="demo-simple-select-placeholder-label")
	private WebElement countrydd;
	
	@FindBy(xpath="//option[text()='State']")
	private WebElement statedd;
	
	@FindBy(id="demo-simple-select-placeholder-label")
	private WebElement citydd;
	
	@FindBy(id="outlined-adornment-pincode")
	private WebElement pincode;
	
	@FindBy(id="outlined-size-small")
	private WebElement phonenum;
	
	@FindBy(name="address")
	private WebElement addressradio;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceesbtn;
	
	public AddressPage(WebDriver driver) {
		super(driver);
	//	PageFactory.initElements(driver, this);
	//	this.driver=driver;
	}
	
	public void addaddress(String name1, String house1, String street1, String landmark1) {
		nametb.sendKeys(name1);
		house.sendKeys(house1);
		street.sendKeys(street1);
		landmark.sendKeys(landmark1);
	}
	
	public void code(String pin, String phone) {
		pincode.sendKeys(pin);
		phonenum.sendKeys(phone);
	}
	
	public Payment addresssradiobtn() {
		addressradio.click();
		proceesbtn.click();
		return new Payment(driver);
	}

}
