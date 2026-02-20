package com.coursera.hooks;

import com.coursera.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        String browserName = System.getProperty("browser","chrome");
        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
