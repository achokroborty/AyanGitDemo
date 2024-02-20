package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class OrderPage extends Abstractmethods {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement>products;
	
	
	
	 public List<WebElement> getproductList() {
		  
		 return products;
	  }
	
	
	
	public Boolean validateplacedOrder(String productName) {
		Boolean match=products.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return match;
	}
}
