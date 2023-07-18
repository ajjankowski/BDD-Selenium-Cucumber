package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoldenmarkPage;
import utils.TestLogger;

import java.util.HashMap;

import static steps.CommonStepDefinition.driver;

public class GoldenmarkPageStepDefinition {

    @Given("I am on goldenmark page")
    public void iAmOnGoldenmarkPage() {
        TestLogger.info("Starting Scenario: Monitor gold coins");
        TestLogger.info("Starting step: I am on goldenmark page");
        driver.get("https://goldenmark.com/pl/");
    }

    @Then("I check current {string} coin price at {string}")
    public void iCheckCurrentCoinPriceAt(String coinName, String coinLink) throws InterruptedException {
        TestLogger.info("Starting step: I check current " + coinName + " coin price at " + coinLink);
        HashMap<String, String> goldenmarkCoinsList = new HashMap<>();
        goldenmarkCoinsList.put(coinName, coinLink);
        new GoldenmarkPage(driver).checkGoldenmarkPrices(goldenmarkCoinsList);
    }
}
