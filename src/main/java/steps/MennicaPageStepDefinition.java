package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MennicaPage;


public class MennicaPageStepDefinition {

    @Given("I am on mennica page")
    public void iAmOnMennicaPage() {
        System.out.println("Starting Scenario \"Check metal base prices\"");
        new MennicaPage(CommonStepDefinition.driver).loadPage();
    }

    @Then("I check if gold price is lower than {int}")
    public void iCheckIfGoldPriceIsLowerThan(int goldPrice) {
        new MennicaPage(CommonStepDefinition.driver).waitUntilPrice("Gold", goldPrice);
    }

    @Then("I check if silver price is lower than {int}")
    public void iCheckIfSilverPriceIsLowerThan(int silverPrice) {
        new MennicaPage(CommonStepDefinition.driver).waitUntilPrice("Silver", silverPrice);
    }
}
