package runTest;

import commons.BaseTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:target/cucumber.json", "json:target/cucumber-report/cucumber.json"},
        features = {"./src/test/resources/features"},
        glue = {"steps", "configuration",
                "commons", "bean"},
        tags = "@CT-01")

public class RunTest extends BaseTest {

}