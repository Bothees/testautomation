package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import com.blackcat.utilities.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by bothees on 27/11/2018.
 */
public class Login {

    @FindBy(id = "email")
    private WebElement usrname;

    @FindBy(id = "password")
    private WebElement passwd;

    @FindBy(id = "submit")
    private WebElement signin;

    @FindBy(css = ".sign-out__user-name")
    private WebElement loginHead;

    @FindBy(id ="signedInUserSignOut")
    private WebElement signout;

    TestContext testContext  = TestContext.getInstance();

    private WebDriver webDriver;
    BasePage basePage;

    public Login(BasePage basePage) {
        this.basePage = basePage;
        webDriver = this.basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    private String url = testContext.readproperty("login.url") ;
    private String username = testContext.readproperty("login.username");
    private String password = testContext.readproperty("login.password") ;


    public void goToLoginpage(){
        webDriver.get(url);
    }

    public void enteruserName(){
        usrname.clear();
        usrname.sendKeys(username);
    }

    public void enteruserPassword(){
        passwd.clear();
        passwd.sendKeys(password);
    }

    public void clickLoginButton(){
        signin.click();
        url = webDriver.getCurrentUrl();
    }

    public String verifyHomepage(){
        String text = basePage.waitForVisibilityOfElement(loginHead).getAttribute("innerText");
        System.out.println("Actual String:"+text);
        return text;
    }

}
