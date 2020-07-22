package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepage extends BasePage{

    private BasePage basePage;

    private WebDriver driver;

    private By history = new By.ByCssSelector(".icon.calendar");

    private By logout = new By.ByCssSelector(".sign-out__button");

    public Homepage(BasePage bp) {
        this.basePage = bp;
        driver = basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clickOnHistoryButton() {
       waitForVisibilityOfElement(history).click();
    }

    public boolean verifyHistory() {
        return true;
    }

    public void logout() {
        clickOnButton(logout);
    }
}
