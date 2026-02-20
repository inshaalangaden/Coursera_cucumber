package com.coursera.hooks;

import com.coursera.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

public class Hooks {
    protected final Logger log = LogManager.getLogger(this.getClass());
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<String> browser = new ThreadLocal<>();

    DriverFactory df = new DriverFactory();

    public WebDriver getDriver(){
        return driver.get();
    }
    public String getBrowser(){
        return browser.get();
    }
    @Before
    public void setUp(@Optional("chrome") String browserName){
        df.intializeDriver(browserName);
    }

    @After
    public void tearDown(){
        df.quitDriver();
    }

}
