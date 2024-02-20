package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class Payments extends Abstractmethods {
	WebDriver driver;
	public Payments(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//div[contains(@class,'small')]/div[@class='title']/following-sibling::input")
	WebElement EnterCVV;
	
	@FindBy(xpath="//div[text()='Name on Card ']/following-sibling::input")
	WebElement EnterCardName;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement SearchCountry;
	
	@FindBy(xpath="//section[contains(@class,'ta-results')]/button[2]/span")
	WebElement Selectcountry;
	
	@FindBy(xpath="//a[contains(@class,'action__submit')]")
	WebElement PlaceOrder;
	By searchresult=By.cssSelector(".ta-results");
	
	
	
	public Orderconfirmation addPaymentinfo(String cvv,String cardName,String searchword) {
		EnterCVV.sendKeys(cvv);
		EnterCardName.sendKeys(cardName);
		SearchCountry.sendKeys(searchword);
		waitForElementToAppear(searchresult);
		Selectcountry.click();
		PlaceOrder.click();
		return new Orderconfirmation(driver);
		
		
	}

}
