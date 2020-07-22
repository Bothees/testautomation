package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import org.openqa.selenium.By;

import java.util.logging.Logger;


public class GoogleHome extends BasePage{

    private By searchBar = By.name("q");

    private By currencyValues = By.cssSelector("table tr td input");

    private By table = By.cssSelector(".obcontainer");

    private static final Logger logger = Logger.getLogger(GoogleHome.class.getName());

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
        openHomePage("https://www.google.co.uk/");
    }

    public void searchForGBPToUSD(String conversion) {
        enterText(searchBar,conversion);
    }

    public int getValueOfPound() {
        return getAttributeFromElement(currencyValues);
    }


    public Double getValueOfDollar(){
        return getAttributeFromElementDouble(currencyValues);
    }

}
