package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.time.Duration;

public class Commands extends RunCucumber {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public static void waitElementBeClickable(By element) {
        new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element) {
        new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    // Se o elemento não aparecer ou não puder ser clicado, o erro sobe e o cenário falha.
    public static void clickElement(By element) {
        System.out.println("Vai clicar no elemento: " + element);
        waitElementBeClickable(element);
        getDriver().findElement(element).click();
    }

    public static void fillField(By element, String value) {
        System.out.println("Vai preencher o campo: " + element);
        waitElementBeClickable(element);
        getDriver().findElement(element).sendKeys(value);
    }

    public static void checkMessage(By element, String expectedMessage) {
        System.out.println("Vai verificar a mensagem: " + expectedMessage);
        waitElementBeVisible(element);
        String actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals("Erro ao validar mensagens", expectedMessage, actualMessage);
    }
}
