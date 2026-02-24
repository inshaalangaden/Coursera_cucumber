package com.coursera.runners;

import com.coursera.base.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.coursera.stepdefs","com.coursera.hooks"},
        monochrome = true, plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browser")
    public void setupBrowser(@Optional("chrome") String browser) {
        System.setProperty("browser",browser);
        DriverFactory.setBrowserName(browser);
    }

}
