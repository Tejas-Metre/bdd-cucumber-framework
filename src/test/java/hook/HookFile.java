package hook;

import java.io.IOException;

import actiondriver.ActionElement;
import dataFactory.DataFactorySetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookFile {

	@Before(order = 1)
	public void before1(Scenario scenario) throws IOException {
		DataFactorySetUp.loadConfig();
		System.out.println("\n🧪==============================");
		System.out.println("📌 Starting Scenario: " + scenario.getName());
		System.out.println("🧪==============================\n");

	}

	@Before(order = 2)
	public void before2() {
		DataFactorySetUp.setup();

	}

	@AfterStep
	public void afterstep(Scenario sc) throws IOException {

		if (sc.isFailed()) {
			byte[] screenshot = ActionElement.getScreenshot();
			sc.attach(screenshot, "image/png", "image");

		}

	}

	@After
	public void after(Scenario scenario) {
		// DataFactorySetUp.stop();
		
		if (scenario.isFailed()) {
			System.out.println("❌ Scenario Failed: " + scenario.getName());
		} else {
			System.out.println("✅ Scenario Passed: " + scenario.getName());
		}
		System.out.println("🔚 End of Scenario");
		System.out.println("-------------------------------\n");
		
	}

}
