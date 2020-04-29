package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.SeleniumWebDriver.getWebDriver;
import static utils.SeleniumWebDriver.setWebDriver;

@CucumberOptions(
        plugin = {"pretty","json:target/report/cucumber2.json"},
        strict = true,
        features = {"src/test/features/amazonSearch.feature"},
        glue = {"steps"}
)
public class AmazonNikonSearchTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    protected void beforeClassTest() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        if (getWebDriver() == null) {
            setWebDriver(getWebDriver("Chrome"));
        }
    }

    @Test(dataProvider = "scenarios")
    public void scenario(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCukes();
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            setWebDriver(null);
        }
        //testNGCucumberRunner.finish(); this gives stream error for some reason
    }
}
