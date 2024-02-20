package rahulshettyacademy.SeleniumFrameWorkDesign.Stepdesigns;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Checkout;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.LandingPage;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Orderconfirmation;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.Payments;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.ProductCatalogue;
import rahulshettyacademy.SeleniumFrameWorkDesign.testcomponents.BaseTest;

public class Stepdefinations extends BaseTest{
	public LandingPage lp;
	ProductCatalogue  pc;
	Checkout cc;
	Payments payment;
	Orderconfirmation oc;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		lp=launchapplication();
	}
   @Given("^Logged in with (.+) and (.+)$")
   public void Logged_in_with_username_and_password(String username,String password) {
	   pc=lp.login(username,password);
   }
   @When("^I add (.+) in the cart$")
   public void Add_Product_in_cart(String productName) throws InterruptedException {
	   List<WebElement>product=pc.getproductList();
		pc.addtoCart(productName);
   }
   @When("^checkout the (.+)$")
   public void checkout_the_product(String productName) {
	   cc=pc.gotoCart();	
	   List<WebElement>cartproductList=cc.getcartproductList();
		Boolean match=cc.matchcartProduct(productName);
		Assert.assertTrue(match);
		payment=cc.checkoutProduct();
   }
   @When("^Submit the order with (.+) and (.+) and (.+)$")
   public void submit_the_order(String CVV,String cardname,String searchwords) {
	   oc=payment.addPaymentinfo(CVV, cardname, searchwords);
	   
   }
   @Then("{string} Validate success message")
   public void validate_success_message(String string) {
	   String Actualconfirmmessage=oc.validateorderConfirmation();
		Assert.assertEquals(Actualconfirmmessage, string);
   }
   @Then("{string} validate error message")
   public void validate_Error_message(String string) {
	   String actualerrormessage=lp.errorValidation();
		Assert.assertEquals(actualerrormessage, string);
   }
   
   
}
