package rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Checkout;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.OrderPage;

public class Abstractmethods {

	WebDriver driver;

	
	public Abstractmethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement addtocart;
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement gotoOrder;
	
	public Checkout gotoCart() {
		addtocart.click();
		Checkout cc=new Checkout(driver);
		return cc;
		
	}
	public OrderPage goOrder() {
		gotoOrder.click();
		OrderPage op =new OrderPage(driver);
		return op;
		
	}
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitforElementtoInvisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
}
