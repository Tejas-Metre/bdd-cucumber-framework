package step.file;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListPage;

public class StepDefinationLogin {

	LoginPage lp;
	ProductListPage plp;
	static WebDriver driver;

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		System.out.println("User enters username " + username + " and password " + password);
		lp = new LoginPage();
		Assert.assertTrue(lp.dataWriting(username, password));

	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("clicks on login button");
		plp = lp.loginButton();
	}

	@Then("User should be redirected to the Products page {string}")
	public void user_should_be_redirected_to_the_products_page(String exceptedText) {
		System.out.println("User should be redirected to the Products page");
	Assert.assertTrue(plp.verifyTextInfoProductPage(exceptedText));

	}

	@Then("user verify invalid credentials error message {string}")
	public void user_verify_invalid_credentials_message_should_be_displayed(String expectedText) {
		System.out.println("Then user verify invalid credentials error message " + expectedText);
		Assert.assertTrue(lp.verifyTextInfoInvalidCredential(expectedText));

	}

	@Then("user verify locked out user error message {string}")
	public void user_verify_locked_out_user_error_message(String expectedText) {
		System.out.println("Then user verify locked out user error message " + expectedText);

		Assert.assertTrue(lp.verifyTextInfoLockOut(expectedText));

	}

	@Then("user verify blank username error message {string}")
	public void user_verify_blank_username_message_should_be_displayed(String expectedText) {
		System.out.println("Then user verify blank username error message " + expectedText);
		Assert.assertTrue(lp.verifyTextInfoWithBlankCredential(expectedText));

	}

}
