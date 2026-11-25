package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/reports/cucumberTests.json", "html:target/reports/cucumber.html"},
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = "not @ignore"
)
public class RunCucumber extends RunBase {

    @AfterClass
    public static void stop() {
        quitDriver();
    }

}
