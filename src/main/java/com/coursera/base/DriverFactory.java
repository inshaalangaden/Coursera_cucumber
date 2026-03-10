package com.coursera.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    Logger log = LogManager.getLogger(this.getClass());
    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    protected static ThreadLocal<String> browserThread = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driverThread.get();
    }
    public static String getBrowser(){
        return browserThread.get();
    }

    public static void setBrowserName(String browser) {
        browserThread.set(browser);
    }

    public static void initializeDriver(){
        WebDriver localDriver;

        if(getBrowser().equalsIgnoreCase("chrome")){
            localDriver = new ChromeDriver();
        } else if (getBrowser().equalsIgnoreCase("edge")) {
            localDriver = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser not supported");
        }

        driverThread.set(localDriver);
    }
    public static void launchWebsite(){
        getDriver().get("https://www.coursera.org/");
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
    }

    public static void quitDriver(){
        if(getDriver() != null) getDriver().quit();
        driverThread.remove();
    }
}
