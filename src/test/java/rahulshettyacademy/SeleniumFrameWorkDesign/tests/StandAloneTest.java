package rahulshettyacademy.SeleniumFrameWorkDesign.tests;




import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("achokroborty@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ria@1991");
		driver.findElement(By.id("login")).click();
		LandingPage lp=new LandingPage(driver);
		//List<WebElement> products=driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']/div/div/h5/b"));
		//WebDriver product=(WebDriver) driver.findElements(By.id("products"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
		//WebElement prod= product.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().or(null);
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		//WebElement prod =products.stream().filter(product->
		//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		List<WebElement>cartproduct=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=cartproduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'small')]/div[@class='title']/following-sibling::input")).sendKeys("123");
		driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys("Ayan Chakraborty");
		
		
	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("//section[contains(@class,'ta-results')]/button[2]/span")).click();
	driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
	
	String Confirmmessage=driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
	Assert.assertEquals(Confirmmessage, "THANKYOU FOR THE ORDER.");
		
		
		
	}

}
