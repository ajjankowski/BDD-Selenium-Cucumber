package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import utils.TestLogger;

import static org.openqa.selenium.OutputType.BYTES;
import static utils.DriverFactory.driver;

public class CommonStepDefinition {

    @Given("I am using {string} browser")
    public static void iAmUsingWebsite(String driverType) {
        TestLogger.info("Starting tests using " + driverType + " driver");
        DriverFactory.setDriver(driverType);
    }

    @After(order = 0)
    public void takeScreenshotOnFailure(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        if (scenario.isFailed()) {
            TestLogger.info("Taking screenshot on failure");
            byte[] src = ts.getScreenshotAs(BYTES);
            scenario.attach(src, "image/png", "Screenshot_failed_Scenario_" + scenario);
        }
    }

    @After(order = 1)
    public static void closeScenario() {
        TestLogger.info("Closing scenario");
        DriverFactory.teardown();
    }
}
