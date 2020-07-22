package com.blackcat.pageobjects;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestFlipKartPagination {

    private static WebDriver webDriver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        wait = new WebDriverWait(webDriver,10);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testSearchMobilePhones() throws InterruptedException {
        webDriver.get("https://www.flipkart.com/");

        webDriver.findElements(By.cssSelector(".fk-modal-visible button")).get(1).click();

        List<WebElement>
            element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector("._3zdbog ._114Zhd li")));

        hoverOverAnElementUsingJS(element.get(0));

        List<WebElement>
            mobiles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector(".QPOmNK li a")));

        moveToElementAndClickUsingJS(mobiles.get(3));

        List<WebElement> viewall = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector(".bhgxx2 a > span")));

        moveToElementAndClickUsingJS(viewall.get(3));

        List<WebElement> prices;
        List<WebElement> pages;

        int index =0;

        boolean flag = false;

        do {

            TimeUnit.SECONDS.sleep(2);

            prices = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector(".bhgxx2 ._2rQ-NK")));

            for (WebElement price : prices) {
                System.out.println(price.getText());
                if (price.getText().equalsIgnoreCase("₹10,200")) {
                    System.out.println("Found");
                    flag = true;
                    break;
                }
            }

            if(flag) {
                break;
            }

            pages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector(".bhgxx2 ._2Xp0TH")));

            moveToElementAndClickUsingJS(pages.get(index));

            index++;

        } while( index != pages.size());

    }

    private void hoverOverAnElementUsingJS(WebElement element) {
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
    }

    private void moveToElementAndClickUsingJS(WebElement element) {
        scrollIntoView(element);
        clickUsingJS(element);
    }

    private void scrollIntoView(WebElement element) {
        if (webDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        }
    }

    private void clickUsingJS(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
    }

}
