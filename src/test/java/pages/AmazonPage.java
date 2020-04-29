package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static utils.SeleniumWebDriver.getWebDriver;

public class AmazonPage extends BasePage{

    public AmazonPage navigate(final String url) {
        Assert.assertNotNull(getWebDriver());
        getWebDriver().get(url);
        waitForPageToLoad();
        assertTrue(getWebDriver().getCurrentUrl().contains("amazon.com"));
        return this;
    }

    public AmazonPage tapSearchBarAndWriteString(final String text) {
        waitForElement(PageLocators.searchBar, 5);
        WebElement searchBar = getWebDriver().findElement(PageLocators.searchBar);
        searchBar.click();
        searchBar.sendKeys(text);
        searchBar.submit();
        waitForPageToLoad();
        assertTrue(getWebDriver().findElement(PageLocators.resultsFoundText).getText()
                .contains("results for \"Nikon\""));
        return this;
    }

    public AmazonPage sortSearchResults(final String sortText) {
        waitForElement(PageLocators.sortDropdownButton, 5);
        getWebDriver().findElement(PageLocators.sortDropdownButton).click();
        waitForElement(PageLocators.sortByHighToLowListText, 10);
        List<WebElement> eleList = getWebDriver().findElements(PageLocators.sortByHighToLowListText);
        for(WebElement ele : eleList) {
            if(ele.getText().contains(sortText)) {
                ele.click();
                break;
            }
        }
        waitForElement(PageLocators.sortDropdownButton, 5);
        assertTrue(getWebDriver().findElement(PageLocators.sortDropdownButton)
                .getText().contains(sortText));
        return this;
    }

    public AmazonPage selectItemFromSearchList(final int itemNumber) {
        waitForElement(PageLocators.resultsList, 10);
        List<WebElement> listOfItems = getWebDriver().findElements(PageLocators.resultsList);
        if(listOfItems.size() > itemNumber) {
            WebElement titleOfItem = listOfItems.get(itemNumber);
            titleOfItem.findElement(By.partialLinkText("")).click();
            assertTrue(getWebDriver().findElement(PageLocators.productTitle).getText()
                    .contains("Nikon D3X"), "Nikon D3X not found.");
        } else {
            fail("No search results found.");
        }
        return this;
    }
}
