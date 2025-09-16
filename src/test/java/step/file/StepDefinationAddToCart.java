package step.file;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListPage;

public class StepDefinationAddToCart {
	static WebDriver driver;
	ProductListPage plp;
	LoginPage lp;



	@Given("User logs in with {string} and {string}")
	public void user_enters_and(String username, String password) {
		System.out.println("When enters username " + username + " and password " + password);
		lp = new LoginPage();
		Assert.assertTrue(lp.dataWriting(username, password));
		plp = lp.loginButton();

	}

	@When("User adds {string} to the cart")
	public void user_adds_to_the_cart(String exceptedProduct) {
		System.out.println("User adds product to the cart");
		plp = new ProductListPage();
		// plp.selectProduct();
		Assert.assertTrue(plp.addProductToCart(exceptedProduct));
	}

	@Then("Cart icon should show {string} item\\(s)")
	public void cart_icon_should_show_item_s(String exceptedCount) {
		System.out.println("Cart icon should show " + exceptedCount + " item(s)");
		Assert.assertTrue(plp.verifyTextInfoOnAddToCart(exceptedCount));

	}

}
