package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import utils.DriverFactory;
import utils.TestLogger;

public class CommonStepDefinition {

    @Given("I am using {string} browser")
    public static void iAmUsingWebsite(String driverType) {
        TestLogger.info("Starting tests using " + driverType + " driver");
        DriverFactory.setDriver(driverType);
    }

    @After
    public static void closeScenario() {
        TestLogger.info("Closing scenario");
        DriverFactory.teardown();
    }
}
