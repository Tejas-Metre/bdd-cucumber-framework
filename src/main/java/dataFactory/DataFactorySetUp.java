package dataFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFactorySetUp {

	public static Properties prop;
	public static WebDriver driver;

	public static void loadConfig() throws IOException {

		prop = new Properties();

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		// System.out.println(path);
		FileInputStream fis = new FileInputStream(path);

		prop.load(fis);
		// System.out.println("load");

	}

	public static void setup() {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser " + browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		System.out.println("url " + url);
		driver.get(url);
	}

	public static void stop() {
		driver.quit();
	}

}
