package com.blackcat.parallel;

import com.blackcat.pageobjects.Homepage;
import com.blackcat.utilities.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepagesteps {

    final static Logger logger = LoggerFactory.getLogger(Homepagesteps.class);

    private BasePage basePage = new BasePage();

    private Homepage home = new Homepage(basePage);

    @Given("^user logged on Homepage$")
    public void user_logged_on_Homepage() throws Throwable {
        logger.info("user logging in to mysupermarket");
    }

    @Given("^click on All history menu$")
    public void click_on_All_history_menu() throws Throwable {
        logger.info("Clicking on History button");
        home.clickOnHistoryButton();
    }

    @Then("^user should see all the information$")
    public void user_should_see_all_the_information() throws Throwable {
//        Assert.assertTrue(true, home.verifyHistory());
    }

    @And("user log out from application")
    public void userLogOutFromApplication() {
        home.logout();
    }

}
