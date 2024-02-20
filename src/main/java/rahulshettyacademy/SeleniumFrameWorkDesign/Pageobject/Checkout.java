package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class Checkout extends Abstractmethods {
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
		@FindBy(css = ".cartSection h3")
		List<WebElement>cartproduct;
		
		@FindBy(xpath="//li[@class='totalRow']/button")
		WebElement clickCheckout;
		
		
		
		public List<WebElement> getcartproductList() {
			
			return cartproduct;
			
			
		}
		
		public Boolean matchcartProduct(String productName) {
			Boolean match=cartproduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
			return match;
			
		}
		
		public Payments checkoutProduct() {
			clickCheckout.click();
			return new Payments(driver);
		}
	

	
}



