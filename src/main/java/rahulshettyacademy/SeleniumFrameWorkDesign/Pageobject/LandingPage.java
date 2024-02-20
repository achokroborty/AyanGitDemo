package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class LandingPage extends Abstractmethods {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//WebElement password=driver.findElement(By.id("userPassword"));
	//WebElement login=driver.findElement(By.id("login"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement Password;
	@FindBy(id="login")
	WebElement userlogin;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void launchApplication() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue login(String EmailID,String userPassword) {
		userEmail.sendKeys(EmailID);
		Password.sendKeys(userPassword);
		userlogin.click();
		
		return new ProductCatalogue(driver);
		
	}
	public String errorValidation() {
		waitForWebElementToAppear(errorMessage);
		
		return errorMessage.getText();
	}
	

}
