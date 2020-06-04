package com.blackcat.parallel;

import com.blackcat.pageobjects.GoogleHome;
import com.blackcat.utilities.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;

public class GoogleHomeSteps {

    private BasePage basePage = new BasePage();

    private GoogleHome googleHome = new GoogleHome(basePage);

    Logger logger = LoggerFactory.getLogger(GoogleHomeSteps.class);

    @Given("^I go to url$")
    public void i_go_to_url() {
        googleHome.goToGoogleHomePage();
    }

    @Given("^I type \"([^\"]*)\" on search bar$")
    public void i_type_on_search_bar(String conversion) {
        googleHome.searchForGBPToUSD(conversion);
    }

    @Then("^I should see GBP value is (\\d+)$")
    public void i_should_see_GBP_value_is(int expectedGBPvalue) {
        MatcherAssert.assertThat("GBP value should be 1",googleHome.getValueOfPound(),is(expectedGBPvalue));;
    }

    @Then("^I should see USD value is greater than (\\d+)$")
    public void i_should_see_USD_value_is_greater_than(Double expectedUSDvalue) {
        logger.info("Dollar Value is"+googleHome.getValueOfDollar());
        MatcherAssert.assertThat("USD value should be greater than 0", googleHome.getValueOfDollar() > expectedUSDvalue);
    }
}
