package com.coursera.base;

import com.coursera.utils.WebInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage extends ActionContainer{
    protected final Logger log = LogManager.getLogger(this.getClass());

    public BasePage(WebDriver driver){
        super(driver);
        WebInitializer.init(driver,this);
    }
}
