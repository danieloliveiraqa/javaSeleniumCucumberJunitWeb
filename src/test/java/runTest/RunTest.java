package runTest;

import commons.BaseTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static report.ReportPDF.gerarPDF;
import static report.ReportPDF2.gerarPDF2;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:target/cucumber.json", "json:target/report/cucumber.json"},
        features = {"./src/test/resources/features"},
        glue = {"steps", "configuration",
                "commons", "bean"},
        tags = "@todos")

public class RunTest extends BaseTest {
    @AfterClass
    public static void report() {
        gerarPDF2();
    }
}