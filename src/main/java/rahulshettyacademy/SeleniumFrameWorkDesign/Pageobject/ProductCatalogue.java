package rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.SeleniumFrameWorkDesign.Abstractmethod.Abstractmethods;

public class ProductCatalogue extends Abstractmethods{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	
	
	@FindBy(css=".ng-animating")
	WebElement spiner;
	
	
	
	By ProductList=By.cssSelector(".mb-3");
	By addTocart=By.cssSelector(".card-body button:last-of-type");
	By  successfulladd=By.id("toast-container");
	//By invisibilityofelement=By.cssSelector(".ng-animating");
	
	
	
  public List<WebElement> getproductList() {
	  waitForElementToAppear(ProductList );
	 return products;
  }
  public WebElement getProductname(String productName) {
	  WebElement prod=getproductList().stream().filter(product->
	  product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	  return prod;
  }
  public Checkout addtoCart(String productName) throws InterruptedException {
	  
	  WebElement prod=getProductname(productName);
	  
	  prod.findElement(addTocart).click();
	  waitForElementToAppear(successfulladd);
	  waitforElementtoInvisible(spiner);
	  
	  
	  return new Checkout(driver);
	 
  }
	
}
