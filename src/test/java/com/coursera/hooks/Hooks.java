package com.coursera.hooks;

import com.coursera.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.Optional;

public class Hooks {
    DriverFactory df = new DriverFactory();

    @Before
    public void setUp(@Optional("chrome") String browserName){
        df.initializeDriver(browserName);
    }

    @After
    public void tearDown(){
        df.quitDriver();
    }

}
