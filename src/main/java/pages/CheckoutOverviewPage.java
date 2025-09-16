package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataFactory.DataFactorySetUp;

public class CheckoutOverviewPage {
	public static WebDriver driver;

	@FindBy(id = "finish")
	WebElement finishButton;

	public CheckoutOverviewPage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public CheckoutCompletePage finishButton() {
		finishButton.click();
		return new CheckoutCompletePage();
	}

}
