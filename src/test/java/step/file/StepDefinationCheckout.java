package step.file;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.ProductListPage;
import pages.YourCartInfoPage;

public class StepDefinationCheckout {

	ProductListPage plp;
	YourCartInfoPage ycp;
	CheckoutYourInformationPage cynp;
	CheckoutOverviewPage cop;
	CheckoutCompletePage ccp;

	@And("User click on cart option to proceeds to checkout")
	public void user_click_on_cart_option_to_proceeds_to_checkout() {
		System.out.println("click on cart option to proceeds to checkout");
		plp = new ProductListPage();
		plp.cartIcon();

	}

	@And("User click on checkout button")
	public void user_click_on_checkout_button() {
		System.out.println("click on checkout button");
		ycp = new YourCartInfoPage();
		cynp = ycp.checkoutButton();
	}

	@And("verify Checkout Your Information page is displayed {string}")
	public void verify_checkout_your_information_page_is_displayed(String exceptedResult) {
		System.out.println("verify Checkout Your Information page is displayed");
		cynp = new CheckoutYourInformationPage();
		Assert.assertTrue(cynp.verifyTextCheckoutInfo(exceptedResult));
	}

	@And("User enters checkout information {string}, {string}, {string}")
	public void user_enters_checkout_information(String firstName, String lastname, String postalcode) {
		System.out.println("User enters checkout information " + firstName + lastname + postalcode);
		Assert.assertTrue(cynp.dataWriting2(firstName, lastname, postalcode));
	}

	@And("User click on continues button")
	public void user_click_on_continues_button() {
		System.out.println("User click on continues button");
		cop = new CheckoutOverviewPage();
		cop = cynp.continueButton();
	}

	@And("User click on finish the order button")
	public void click_on_finish_the_order_button() {
		System.out.println("User click on finish the order button");
		ccp = new CheckoutCompletePage();
		ccp = cop.finishButton();
	}

	@Then("Order confirmation page should be displayed {string}")
	public void order_confirmation_page_should_be_displayed(String exceptedText) {
		System.out.println("Order confirmation page should be displayed " + exceptedText);
		Assert.assertTrue(ccp.verifyTextOrderConformation(exceptedText));
	}

	@And("User click on Back Home button")
	public void user_click_on_back_home_button() {
		System.out.println("User click on Back Home button");
		plp = ccp.backHomeButton();
	}

}
