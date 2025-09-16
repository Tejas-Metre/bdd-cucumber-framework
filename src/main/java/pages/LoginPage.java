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

public class LoginPage {
	static WebDriver driver;

	@FindBy(id = "user-name")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "login-button")
	WebElement Login;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
	WebElement ErrorMsg;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
	WebElement ErrorMsgLockOut;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
	WebElement ErroMsgBlankCredential;

	// @FindBy(name="login-button")
	// WebElement verifyLoginPage;

	public LoginPage() {
		driver = DataFactorySetUp.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean dataWriting(String searchData1, String searchData2) {

		boolean status = true;
		if (ActionElement.writeData(UserName, searchData1))

			status = ActionElement.writeData(Password, searchData2);

		return status;

	}

	public ProductListPage loginButton() {
		Login.submit();
		return new ProductListPage();

	}

	public boolean verifyTextInfoInvalidCredential(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(ErrorMsg, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;
	}

	public boolean verifyTextInfoLockOut(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(ErrorMsgLockOut, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;
	}

	public boolean verifyTextInfoWithBlankCredential(String expectedText) {
		boolean status = ActionElement.verifyTextInfo(ErroMsgBlankCredential, expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;
	}

	public boolean verifyTextLoginPage(String expectedText) {

		String ActualResult = Login.getAttribute("value");
		// System.out.println("ActualResult"+ActualResult);
		boolean status = ActualResult.contains(expectedText);
		if (status)
			System.out.println("✔ Verified: Expected message is displayed- " + expectedText);
		else
			System.out.println("❌ Not Verified: Expected message was not displayed. Expected: " + expectedText);
		return status;

	}

}
