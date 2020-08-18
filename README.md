# GreenApp Test Automation Framework
Parallel Execution of Feature file with more than one Runner class.
Maven SureFire plugin used to execute tests parallel.

ThreadLocal<WebDriver> used to instantiate driver for each every test.
    
clueCucumber report plugin used to generate combined report.


## Notes about the Test Framework

This Test Framework is built with Following tech stack:
* Java
* Selenium 3+
* Cucumber
* Maven
* TestNG

### How to run the tests

* Clone the repostory locally (git clone https://bothi@bitbucket.org/bothi/testautomation.git)
* Create a TestNG Runner with following VM options (Framework supports running tests using latest firefox and chrome browsers)
* Runner Class to be selected is : com.blackcat.RunCuckesTest
    `-Dbrowser=firefox -Dcucumber.options="--tags @test"`

#### WebDriverManager:
WebDriverManager dependency used to download the Browser Drivers on the fly.


#### Sample Test:
For simplicity, a test written to open the Moneysupermarket website and login to verify the logged in username.
PageFactory model is used to initialise locators.
