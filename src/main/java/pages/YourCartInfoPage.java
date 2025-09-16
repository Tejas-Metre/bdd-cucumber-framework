package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataFactory.DataFactorySetUp;

public class YourCartInfoPage {
	static WebDriver driver;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;

	public YourCartInfoPage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public CheckoutYourInformationPage checkoutButton() {
		checkoutButton.click();
		return new CheckoutYourInformationPage();
	}

}
