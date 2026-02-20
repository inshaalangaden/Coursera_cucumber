package com.coursera.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    protected final Logger log = LogManager.getLogger(this.getClass());
    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    protected static ThreadLocal<String> browserThread = new ThreadLocal<>();
    protected WebDriver localDriver;

    public static WebDriver getDriver(){
        return driverThread.get();
    }
    public static String getBrowser(){
        return browserThread.get();
    }

    public void initializeDriver(String browserName){
        browserThread.set(browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            log.info("Setting up the browser: CHROME");
            localDriver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            log.info("Setting up the browser: EDGE");
            localDriver = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser not supported");
        }
        driverThread.set(localDriver);
        localDriver.get("https://www.coursera.org/");
        localDriver.manage().window().maximize();
        localDriver.manage().deleteAllCookies();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver(){
        log.info("Closing the browser");
        if(localDriver != null) localDriver.quit();
        driverThread.remove();
    }
}
