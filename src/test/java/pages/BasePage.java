package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertNotNull;
import static utils.SeleniumWebDriver.getWebDriver;

public class BasePage {

    private static final int DEFAULT_WAIT_TIMEOUT_SHORT_SECONDS = 10;

    void waitForPageToLoad() {
        final WebDriverWait driverWait = new WebDriverWait(getWebDriver(), DEFAULT_WAIT_TIMEOUT_SHORT_SECONDS);
        driverWait.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").toString().toLowerCase()
                .equals("complete"));
    }

    void waitForElement(final By locator, final int timeout) {
        assertNotNull(locator);
        final WebDriverWait driverWait = new WebDriverWait(getWebDriver(), timeout);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
