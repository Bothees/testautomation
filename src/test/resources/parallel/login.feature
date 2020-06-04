@login
Feature: login to the Application
  Background:
    Given user am on LoginPage
    When user enter valid username
    And user enter valid password
    And user click on login button


  Scenario: valid username and password should be able to login to the application
    Then user should see the homepage
    And user log out from application

  Scenario: user logged in and user has to see the history page
    Then user should not see the homepage
    And user log out from application

