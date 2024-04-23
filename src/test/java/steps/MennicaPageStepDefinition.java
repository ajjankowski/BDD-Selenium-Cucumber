package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MennicaPage;
import utils.DriverFactory;

import static utils.TestLogger.log;

public class MennicaPageStepDefinition {

    @Given("I am on mennica page")
    public void iAmOnMennicaPage() {
        log.info("Starting Scenario: Check metal base prices");
        log.info("Starting step: I am on mennica page");
        new MennicaPage(DriverFactory.driver).loadPage();
    }

    @Then("I check if gold price is lower than {int}")
    public void iCheckIfGoldPriceIsLowerThan(int goldPrice) {
        log.info("Starting step: I check if gold price is lower than " + goldPrice);
        new MennicaPage(DriverFactory.driver).waitUntilPrice("Gold", goldPrice);
    }

    @Then("I check if silver price is lower than {int}")
    public void iCheckIfSilverPriceIsLowerThan(int silverPrice) {
        log.info("Starting step: I check if silver price is lower than " + silverPrice);
        new MennicaPage(DriverFactory.driver).waitUntilPrice("Silver", silverPrice);
    }
}
