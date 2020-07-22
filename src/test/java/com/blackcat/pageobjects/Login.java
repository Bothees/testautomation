package com.blackcat.pageobjects;

import com.blackcat.utilities.BasePage;
import org.openqa.selenium.By;

public class Login extends BasePage{

    private By usrname = new By.ById("email");

    private By passwd = new By.ById("password");

    private By signin = new By.ById("submit");

    private By loginHead = By.cssSelector(".sign-out__user-name");

    private By signout = new By.ById("signedInUserSignOut");

    public void goToLoginpage(){
       openHomePage();
    }

    public void enteruserName(){
        enterText(usrname,"username");
    }

    public void enteruserPassword(){
       enterText(passwd,"password");
    }

    public void clickLoginButton(){
        clickOnButton(signin);
    }

    public String verifyHomepage(){
        String text = waitForVisibilityOfElement(loginHead).getAttribute("innerText");
        System.out.println("Actual String:"+text);
        return text;
    }

}
