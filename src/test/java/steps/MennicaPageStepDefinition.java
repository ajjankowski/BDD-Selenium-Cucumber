package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MennicaPage;
import utils.DriverFactory;
import utils.TestLogger;

public class MennicaPageStepDefinition {

    @Given("I am on mennica page")
    public void iAmOnMennicaPage() {
        TestLogger.info("Starting Scenario: Check metal base prices");
        TestLogger.info("Starting step: I am on mennica page");
        new MennicaPage(DriverFactory.driver).loadPage();
    }

    @Then("I check if gold price is lower than {int}")
    public void iCheckIfGoldPriceIsLowerThan(int goldPrice) {
        TestLogger.info("Starting step: I check if gold price is lower than " + goldPrice);
        new MennicaPage(DriverFactory.driver).waitUntilPrice("Gold", goldPrice);
    }

    @Then("I check if silver price is lower than {int}")
    public void iCheckIfSilverPriceIsLowerThan(int silverPrice) {
        TestLogger.info("Starting step: I check if silver price is lower than " + silverPrice);
        new MennicaPage(DriverFactory.driver).waitUntilPrice("Silver", silverPrice);
    }
}
