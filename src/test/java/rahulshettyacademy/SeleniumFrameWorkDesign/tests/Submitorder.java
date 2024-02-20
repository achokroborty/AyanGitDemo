package rahulshettyacademy.SeleniumFrameWorkDesign.tests;




import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Checkout;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.LandingPage;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.OrderPage;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Orderconfirmation;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Payments;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.ProductCatalogue;
import rahulshettyacademy.SeleniumFrameWorkDesign.testcomponents.BaseTest;

public class Submitorder extends BaseTest {
	//String EmailID="achokroborty@gmail.com";
	//String userPassword="Ria@1991";
	//String productName = "ZARA COAT 3";
	String cvv="123";
	String cardName="Ayan Chakraborty";
	String searchword="India";
	String Expectedconfirmmessage="THANKYOU FOR THE ORDER.";
@Test(dataProvider="getdata")
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
			
		ProductCatalogue pc=lp.login(input.get("email"),input.get("password"));
		List<WebElement>product=pc.getproductList();
		pc.addtoCart(input.get("product"));
		//pc.getProductname(productName);
		Checkout cc=pc.gotoCart();		
		List<WebElement>cartproductList=cc.getcartproductList();
		Boolean match=cc.matchcartProduct(input.get("product"));
		Assert.assertTrue(match);
		Payments payment=cc.checkoutProduct();
		Orderconfirmation oc=payment.addPaymentinfo(cvv, cardName, searchword);
		String Actualconfirmmessage=oc.validateorderConfirmation();
		Assert.assertEquals(Actualconfirmmessage, Expectedconfirmmessage);

		
		//driver.findElement(By.id("userEmail")).sendKeys("achokroborty@gmail.com");
		//	driver.findElement(By.id("userPassword")).sendKeys("Ria@1991");
			//driver.findElement(By.id("login")).click();
		
		//List<WebElement> products=driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']/div/div/h5/b"));
		//WebDriver product=(WebDriver) driver.findElements(By.id("products"));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
		//WebElement prod= product.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().or(null);
		//WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		//WebElement prod =products.stream().filter(product->
		//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		// prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		//List<WebElement>cartproduct=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		//Boolean match=cartproduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase("ZARA COAT 3"));
		//Assert.assertTrue(match);
		//driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		
		//driver.findElement(By.xpath("//div[contains(@class,'small')]/div[@class='title']/following-sibling::input")).sendKeys(cvv);
		//driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys(cardName);
		
		
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(searchword);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//driver.findElement(By.xpath("//section[contains(@class,'ta-results')]/button[2]/span")).click();
	//driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
	
	//String Confirmmessage=driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
	//Assert.assertEquals(Confirmmessage, "THANKYOU FOR THE ORDER.");
		
		
		
	}

@Test(dataProvider="getdata",dependsOnMethods={"submitorder"})
public void validateOrder(String EmailID,String userPassword,String productName) throws IOException {
	
	ProductCatalogue pc=lp.login(EmailID,userPassword);
	OrderPage op=pc.goOrder();
	
	Assert.assertTrue(op.validateplacedOrder(productName));
	
}
/*
@DataProvider
public Object[][] getdata() {
	return new Object[][] {{"achokroborty@gmail.com","Ria@1991","ZARA COAT 3"},{"achokroborty@yahoo.com","Ria@1992","ADIDAS ORIGINAL"}};
}
*/
@DataProvider
public Object[][] getdata() throws IOException{
	
	/*HashMap<String,String>map=new HashMap<String,String>();
	map.put("email", "achokroborty@gmail.com");
	map.put("password", "Ria@1991");
	map.put("product", "IPHONE 13 PRO");
	
	HashMap<String,String>map1=new HashMap<String,String>();
	map1.put("email", "achokroborty@yahoo.com");
	map1.put("password", "Ria@1992");
	map1.put("product", "ZARA COAT 3");*/
	
	List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//SeleniumFrameWorkDesign//Testdata//purchase.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
}



}
