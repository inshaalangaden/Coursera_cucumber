package com.coursera.hooks;

import com.coursera.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        String browser = DriverFactory.getBrowser().toUpperCase();
        com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter
                .getCurrentScenario().assignCategory(browser);
        DriverFactory.initializeDriver();
    }

    @After(order = 2)
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
