package step.file;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BackgroundStep {

	@Given("User opens the browser")
	public void user_opens_the_browser() {
		System.out.println("User opens the browser");
	}

	@Given("navigates to {string}")
	public void navigates_to(String url) {
		System.out.println("navigates to url-https://www.saucedemo.com");

	}

}
