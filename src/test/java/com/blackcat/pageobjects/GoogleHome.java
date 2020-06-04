package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.logging.Logger;


public class GoogleHome {

    private BasePage basePage;

    private By searchBar = By.name("q");

    @FindBy(css="table tr td input")
    List<WebElement> currencyValues;

    @FindBy(css=".obcontainer")
    private WebElement table;

    private WebDriver driver;

    private static final Logger logger = Logger.getLogger(GoogleHome.class.getName());

    public GoogleHome(BasePage basePage) {
        this.basePage = basePage;
        driver = this.basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,30),this);
    }

    int explicitWaitTime=-1;

    private static final int DEFAULT_POLLING_IN_MILLS = 500;


    public int getExplicitWaitTime() {
        if (explicitWaitTime == -1) {
            String explicitWaitString = System.getProperty("explicitWait");
            if (explicitWaitString == null) {
                explicitWaitString = "120";
            }
            explicitWaitTime = Integer.parseInt(explicitWaitString);
        }
        return explicitWaitTime;
    }

    public void goToGoogleHomePage() {
        driver.navigate().to("https://www.google.co.uk/");
    }

    public void searchForGBPToUSD(String conversion) {
        basePage.enterText(this.driver,searchBar,conversion);
    }

    public int getValueOfPound() {
        return Integer.parseInt(currencyValues.get(0).getAttribute("value"));
    }

    public Double getValueOfDollar(){
        return Double.valueOf(currencyValues.get(1).getAttribute("value"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        logger.info("###########" + scenario.getName() + " Finished with status  " + scenario.getStatus() + "##########");
    }

}
