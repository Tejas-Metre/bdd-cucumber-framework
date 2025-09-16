package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.ActionElement;
import dataFactory.DataFactorySetUp;

public class CheckoutYourInformationPage {
	static WebDriver driver;

	@FindBy(xpath = "//*[@class='title']")
	WebElement verifyCheckoutInfo;

	@FindBy(xpath = "//*[@id=\"first-name\"]")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	public CheckoutYourInformationPage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTextCheckoutInfo(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(verifyCheckoutInfo, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;

	}

	// 6. Enter firstname , lastname, zipcode
	public boolean dataWriting2(String searchData1, String searchData2, String searchData3) {

		boolean status = true;
		if (ActionElement.writeData(firstName, searchData1))

			status = ActionElement.writeData(lastName, searchData2);
		status = ActionElement.writeData(postalCode, searchData3);

		return status;

	}

	public CheckoutOverviewPage continueButton() {
		continueButton.click();
		return new CheckoutOverviewPage();
	}

}
