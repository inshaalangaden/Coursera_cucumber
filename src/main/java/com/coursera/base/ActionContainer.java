package com.coursera.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionContainer {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ActionContainer(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void type(WebElement element, String content){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(content);
    }

    protected void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void select(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    protected String  getText(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }


}
