@conversion
Feature: Check Conversion rate for GBP to USD
    As a customer
    When I go to Google home page and enter gbp to usd I should get the conversion rate

    Scenario: GBP to USD conversion
        Given I go to url
        And I type "1 gbp to usd" on search bar
        Then I should see GBP value is 1
        And I should see USD value is greater than 0
