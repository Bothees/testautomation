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

    TestContext testContext  = TestContext.getInstance();

    private String url = testContext.readproperty("login.url") ;
    private String username = testContext.readproperty("login.username");
    private String password = testContext.readproperty("login.password") ;

    public BasePage() {
        setWebDriver();
        webdriverWait = new WebDriverWait(this.webDriver, DRIVER_WAIT_TIME);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void setWebDriver() {
        DriverFactory driverFactory = DriverFactory.getInstance();
        this.webDriver = driverFactory.getDriver();
    }

    public WebElement waitForVisibilityOfElement(By element) {
        return webdriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(element)));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> elements) {
        return webdriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void enterText(By element, String text) {
        if("username".equalsIgnoreCase(text)) {
            text = username;
        } else if("password".equalsIgnoreCase(text)) {
            text = password;
        }
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement e = webDriver.findElement(element);
        e.click();
        e.clear();
        e.sendKeys(text);
        e.submit();
    }
    public void openHomePage() {
        webDriver.get(url);
    }

    public void openHomePage(String url) {
        webDriver.navigate().to(url);
    }

    public void clickOnButton(By locator) {
        webdriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement e = webDriver.findElement(locator);
        e.click();
    }

    public int getAttributeFromElement(By locator) {
        return Integer.parseInt(webDriver.findElements(locator).get(0).getAttribute("value"));
    }

    public Double getAttributeFromElementDouble(By locator) {
        return Double.valueOf(webDriver.findElements(locator).get(1).getAttribute("value"));
    }
}
