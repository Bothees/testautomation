package com.blackcat.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BasePage {

    private static long DRIVER_WAIT_TIME = 30;

    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    WebDriverWait webdriverWait;

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        this.webDriver =DriverFactory.getInstance().getDriver();
        webdriverWait = new WebDriverWait(this.webDriver, DRIVER_WAIT_TIME);
        return webDriver;
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        return webdriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> elements) {
        return webdriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void enterText(WebDriver driver,By element, String text) {
        WebElement e = driver.findElement(element);
        e.click();
        e.clear();
        e.sendKeys(text);
        e.submit();
    }
}
