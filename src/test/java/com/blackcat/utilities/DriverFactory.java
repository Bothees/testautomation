package com.blackcat.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    private static final String BROWSER = StringUtils.isEmpty(System.getProperty("browser"))?"chrome":System.getProperty("browser");

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    private WebDriver getLocalDriver() {
        switch (BROWSER.toUpperCase()) {
            case "CHROME":
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                return new ChromeDriver();
            case "FIREFOX":
                FirefoxOptions ffOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(ffOptions);
            default:
                throw new RuntimeException("Browser type " + BROWSER + " Not supported");
        }
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {
            return getLocalDriver(); // can be replaced with other browser drivers
        }
    };

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void removeDriver()
    {
        driver.get().quit();
        driver.remove();
    }


}
