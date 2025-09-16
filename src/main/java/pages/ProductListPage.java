package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.ActionElement;
import dataFactory.DataFactorySetUp;

public class ProductListPage {
	static WebDriver driver;
	@FindBy(className = "title")
	WebElement Productpage;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement AddToCart;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")
	WebElement SelectProduct;

	@FindBy(className = "shopping_cart_badge")
	WebElement AddTocartCount;

	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement cartIcon;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menuButton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

	public ProductListPage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTextInfoProductPage(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(Productpage, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;
	}

	public boolean addProductToCart(String productName) {
		if (productName.equalsIgnoreCase("Sauce Labs Backpack")) {
			AddToCart.click();
			System.out.println(productName + "---- added to cart----");

			return true;
		} else {
			System.out.println("product not added: " + productName);
		}
		return false;

	}

	public boolean verifyTextInfoOnAddToCart(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(AddTocartCount, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;

	}

	public YourCartInfoPage cartIcon() {
		cartIcon.click();
		return new YourCartInfoPage();

	}

	public ProductListPage menuButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(menuButton));
		menuButton.click();

		return new ProductListPage();
	}

	public LoginPage logoutButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logoutButton));

		logoutButton.click();
		return new LoginPage();
	}

}