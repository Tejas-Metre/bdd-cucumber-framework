package step.file;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListPage;

public class StepDefinationLogout {
	ProductListPage plp;
	LoginPage lp;

	@When("User clicks on the menu")
	public void user_clicks_on_the_menu() {
		System.out.println("User clicks on the menu");
		plp = new ProductListPage();
		plp.menuButton();

	}

	@And("User clicks logout")
	public void user_clicks_logout() {
		System.out.println("User clicks logout");
		lp = new LoginPage();
		lp = plp.logoutButton();

	}

	@Then("verify User should be redirected to the login page {string}")
	public void verify_user_should_be_redirected_to_the_login_page(String exceptedResult) {

		System.out.println("verify User should be redirected to the login page");
		Assert.assertTrue(lp.verifyTextLoginPage(exceptedResult));
	}

}
