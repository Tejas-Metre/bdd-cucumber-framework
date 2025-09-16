package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionElement;
import dataFactory.DataFactorySetUp;

public class CheckoutCompletePage {
	public static WebDriver driver;
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement orderConfirm;

	@FindBy(id = "back-to-products")
	WebElement backHome;

	public CheckoutCompletePage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTextOrderConformation(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(orderConfirm, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;

	}

	public ProductListPage backHomeButton() {
		backHome.click();
		return new ProductListPage();
	}

}
