package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@coins", features = "src/test/cucumber/java/features", glue = "cucumber", plugin = {"pretty", "html:target/cucumber"})
public class RunAllFeaturesTest {
}