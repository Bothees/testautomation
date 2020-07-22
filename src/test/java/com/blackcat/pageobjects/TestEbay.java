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
import java.util.stream.Collectors;

public class TestEbay {

    private static WebDriver webDriver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        wait = new WebDriverWait(webDriver, 10);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    @Test
    public void test() {
        webDriver.get("https://www.ebay.co.uk/");
        webDriver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("shoes");
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByCssSelector(".ui-front li a")));
        elementList.stream().map(WebElement::getText).collect(Collectors.toList()).forEach(System.out::println);
        WebElement result = elementList.stream().filter(element -> element.getText().equals("shoes size 4")).findFirst().orElseThrow(() -> new RuntimeException("No element found"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", result);
    }
}
