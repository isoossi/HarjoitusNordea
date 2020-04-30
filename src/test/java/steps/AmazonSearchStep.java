package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.AmazonPage;

public class AmazonSearchStep {

    @Given("^user goes to amazon$")
    public void userGoesToAmazon() {
        final AmazonPage amazonPage = new AmazonPage();
        amazonPage.navigate("http://amazon.com/");
    }

    @When("^user search for Nikon$")
    public void userSearchForNikon() {
        final AmazonPage amazonPage = new AmazonPage();
        amazonPage.tapSearchBarAndWriteString("Nikon");
    }

    @When("^user clicks sort products from High to Low$")
    public void userClicksSortProductsFromHighToLow() {
        final AmazonPage amazonPage = new AmazonPage();
        amazonPage.sortSearchResults("Price: High to Low");
    }

    @When("^user clicks second product$")
    public void userClicksSecondProduct() {
        final AmazonPage amazonPage = new AmazonPage();
        amazonPage.selectItemFromSearchList(1);
    }
}
