package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    // -Dbrowser=chrome | chrome-ci | firefox | edge (padrão: chrome)
    public static WebDriver getDriver(String browser) {

        if (driver != null) {
            driver.quit();
        }

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        // O Selenium Manager baixa o driver certo para o navegador instalado
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "chrome-ci":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new", "--window-size=1280,1024");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, chrome-ci, firefox ou edge.");
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
