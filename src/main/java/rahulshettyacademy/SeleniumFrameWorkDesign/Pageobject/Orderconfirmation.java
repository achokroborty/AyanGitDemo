package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class Orderconfirmation extends Abstractmethods {
	WebDriver driver;
	public Orderconfirmation(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement confirmmessage;
	
	public String validateorderConfirmation() {
		return confirmmessage.getText();
		
		
		 
	}
	

}
