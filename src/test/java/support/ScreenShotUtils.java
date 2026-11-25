package support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenShotUtils {

    public static void addScreenShotOnScenario(Scenario scenario) {
        System.out.println("Cenário: " + scenario.getName() + " | Status: " + scenario.getStatus()
                + " | Tags: " + scenario.getSourceTagNames());

        if (scenario.isFailed() && getDriver() != null) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
