package com.blackcat;

import com.blackcat.utilities.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
                 plugin = { "pretty", "html:target/cucumber-html-report",
                            "json:target/cucumber-report/cucumber1.json"},
                 strict = true,
                 features ="src/test/resources/parallel",
                 tags = {"@login"},
                 glue =   {"com.blackcat.utilities",
                         "com.blackcat.parallel","com.blackcat.pageobjects"})
public class RunCuckes2Test extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getInstance().removeDriver();
    }


}









