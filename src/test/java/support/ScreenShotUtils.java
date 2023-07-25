package support;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenShotUtils {

    public static void addScreenShotOnScenario(Scenario scenario) {
        System.out.println("##########################################");
        System.out.println("Teste sendo executado - " + scenario.getName());
        System.out.println("Status - " + scenario.getStatus());
        System.out.println("Tag - " + scenario.getSourceTagNames());
        System.out.println("##########################################");

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
