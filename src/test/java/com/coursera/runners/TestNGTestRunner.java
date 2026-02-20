package com.coursera.runners;

import com.coursera.base.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.coursera.stepdefs","com.coursera.hooks"},
        monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browser")
    public void setupBrowser(String browser) {
        DriverFactory.setBrowserName(browser);
    }

}
