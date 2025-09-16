package actiondriver;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import dataFactory.DataFactorySetUp;
import pages.ProductListPage;

public class ActionElement {

	public static boolean writeData(WebElement ele, String data1) {

		if (ele.isDisplayed() && ele.isEnabled()) {
			ele.sendKeys(data1);
			// eles.sendKeys(data2);

			return true;
		} else {
			System.out.println("Element not found");
			return false;
		}

	}

	public static boolean verifyTextInfo(WebElement elc, String expectedText) {
		String actualText = elc.getText();
		// System.out.println("ActualText:" +actualText);

		if (actualText.equals(expectedText)) {
			// System.out.println("Verified--");
			return true;
		} else {
			// System.out.println("not Verified--");
			return false;
		}

	}

	public static byte[] getScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DataFactorySetUp.driver;
		final byte[] source = ts.getScreenshotAs(OutputType.BYTES);

		return source;
	}

}
