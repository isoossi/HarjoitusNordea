package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SeleniumWebDriver {

    private static final ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();

    public static WebDriver getWebDriver(final String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
                final FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile());
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("detach", true);
                //chromeOptions.addArguments("--start-fullscreen");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        return driver;
    }

    public static WebDriver getWebDriver() {
        return WEB_DRIVER.get();
    }

    public static void setWebDriver(final WebDriver driver) {
        WEB_DRIVER.set(driver);
    }
}
