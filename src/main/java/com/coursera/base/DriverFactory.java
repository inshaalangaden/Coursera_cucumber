package com.coursera.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    protected final Logger log = LogManager.getLogger(this.getClass());
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<String> browser = new ThreadLocal<>();

    public WebDriver getDriver(){
        return driver.get();
    }
    public String getBrowser(){
        return browser.get();
    }

    public void intializeDriver(String browserName){
        browser.set(browserName);
        WebDriver localDriver;
        if(browserName.equalsIgnoreCase("chrome")){
            log.info("Setting up the browser: CHROME");
            localDriver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            log.info("Setting up the browser: EDGE");
            localDriver = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser not supported");
        }
        driver.set(localDriver);
        getDriver().get("https://www.coursera.org/");
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver(){
        log.info("Closing the browser");
        if(getDriver() != null) getDriver().quit();
        driver.remove();
    }
}
