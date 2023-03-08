package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends BasePage{
	
	public WebDriver driver;
	
	@FindBy(id="fl_email")
	private WebElement emailtb;
	
	@FindBy(id="fl_password")
	private WebElement passwordtb;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginbtn;
	
	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		//this.driver=driver;
	}
	
	public HomePage logindetails(String email, String pwd) {
		emailtb.sendKeys(email);
		passwordtb.sendKeys(pwd);
		loginbtn.click();
		return new HomePage(driver);
	}

}
