package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{
	public WebDriver driver;
	
	@FindBy(xpath="//button[text()='Add Card']")
	private WebElement addcard;
	
	@FindBy(xpath="//input[@placeholder='John Wick']")
	private WebElement name;
	
	@FindBy(xpath="//span[text()='Card Number']")
	private WebElement cardnum;
	
	@FindBy(xpath="//span[text()='PIN']")
	private WebElement pin;
	
	@FindBy(xpath="//span[text()='Expiry Month']")
	private WebElement  expirymonth;
	
	@FindBy(xpath="//span[text()='Expiry Year']")
	private WebElement expiryyear;
	
	@FindBy(xpath="//span[text()='CVV']")
	private WebElement cvv;
	
	@FindBy(xpath="//input[@value='DEBIT']")
	private WebElement debit;
	
	@FindBy(xpath="//input[@type='radio']")
	private WebElement radio;
	
	@FindBy(xpath="//span[text()='PIN']")
	private WebElement pintb;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceedbtn;
	
	public PaymentPage(WebDriver driver) {
	super(driver);
	//	PageFactory.initElements(driver, this);
	//	this.driver=driver;
	}
	
	public void carddetails(String acct, String cno, String pinno, String expm, String expy,String cvvno) {
		name.sendKeys(acct);
		cardnum.sendKeys(cno);
		pin.sendKeys(pinno);
		expirymonth.sendKeys(expm);
		expiryyear.sendKeys(expy);
		cvv.sendKeys(cvvno);
		//pintb.sendKeys(pinnum);
			
	}
	public void cards() {
		debit.click();
		radio.click();
		
		submitbtn.click();
		proceedbtn.click();
	}

}
