package com.coursera.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    //protected static final Logger log = LogManager.getLogger(this.getClass());
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
            //log.info("Setting up the browser: CHROME");
            localDriver = new ChromeDriver();
        } else if (getBrowser().equalsIgnoreCase("edge")) {
            //log.info("Setting up the browser: EDGE");
            localDriver = new EdgeDriver();
        }else{
            throw new RuntimeException("Browser not supported");
        }

        driverThread.set(localDriver);
        getDriver().get("https://www.coursera.org/");
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver(){
        //log.info("Closing the browser");
        if(getDriver() != null) getDriver().quit();
        driverThread.remove();
    }
}
