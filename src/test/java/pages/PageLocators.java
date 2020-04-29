package pages;

import org.openqa.selenium.By;

class PageLocators {
    public static final By searchBar = By.id("twotabsearchtextbox");
    public static final By sortDropdownButton = By.className("a-dropdown-prompt");
    public static final By sortByHighToLowListText = By.className("a-dropdown-link");
    public static final By resultsFoundText = By.className("sg-col-inner");
    public static final By resultsList = By.cssSelector("div[data-component-type=\"s-search-result\"]");
    public static final By productTitle = By.id("productTitle");
}
