package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import support.ScreenShotUtils;

public class Hooks {

    // Screenshot anexado ao relatório quando o cenário falha
    @After
    public void afterScenario(Scenario scenario) {
        ScreenShotUtils.addScreenShotOnScenario(scenario);
    }
}
