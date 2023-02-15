package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoldenmarkPage;

import java.util.HashMap;

public class GoldenmarkPageStepDefinition {

    @Given("I am on goldenmark page")
    public void iAmOnGoldenmarkPage() {
        System.out.println("Starting Scenario \"Monitor gold coins\"");
        CommonStepDefinition.driver.get("https://goldenmark.com/pl/");
    }

    @Then("I check current {string} coin price at {string}")
    public void iCheckCurrentCoinPriceAt(String coinName, String coinLink) throws InterruptedException {
        HashMap<String, String> goldenmarkCoinsList = new HashMap<>();
        goldenmarkCoinsList.put(coinName, coinLink);
        new GoldenmarkPage(CommonStepDefinition.driver).checkGoldenmarkPrices(goldenmarkCoinsList);
    }
}
