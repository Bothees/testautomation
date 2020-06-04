package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepage {

    private BasePage basePage;

    private WebDriver driver;

    @FindBy(css = ".icon.calendar")
    private WebElement history;

    @FindBy(css=".sign-out__button")
    private WebElement logout;

    public Homepage(BasePage bp) {
        this.basePage = bp;
        driver = basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clickOnHistoryButton() {
       basePage.waitForVisibilityOfElement(history).click();
    }

    public boolean verifyHistory() {
        return true;
    }

    public void logout() {
        logout.click();
    }
}
