package runTest;

import com.itextpdf.text.DocumentException;
import commons.BaseTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import report.ReportPDF;

import java.io.FileNotFoundException;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:target/report/cucumber.json"},
        features = {"./src/test/resources/features"},
        glue = {"steps", "configuration",
                "commons", "bean"},
        tags = "@CT-02")

public class RunTest extends BaseTest {

    @BeforeClass
    public static void report() {
        ReportPDF.initReport("report.pdf");
    }


    @AfterClass
    public static void report2() {
        ReportPDF.closeReport();
    }
}