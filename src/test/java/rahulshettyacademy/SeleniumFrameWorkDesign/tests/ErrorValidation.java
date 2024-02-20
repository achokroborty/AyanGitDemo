package rahulshettyacademy.SeleniumFrameWorkDesign.tests;




import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Checkout;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.LandingPage;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Orderconfirmation;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Payments;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.ProductCatalogue;
import rahulshettyacademy.SeleniumFrameWorkDesign.testcomponents.BaseTest;

public class ErrorValidation extends BaseTest {
@Test
	public void submitorder() throws IOException {
		// TODO Auto-generated method stub
		String EmailID="achokroborty@gmail.com";
		String userPassword="Ria@1291";
		String expectedErrormessage="Incorrect email or password.";
		
		lp.login(EmailID,userPassword);
		String actualerrormessage=lp.errorValidation();
		Assert.assertEquals(actualerrormessage, expectedErrormessage);
				
	}

}
