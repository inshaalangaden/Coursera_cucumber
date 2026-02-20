package com.coursera.pages;

import com.coursera.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    By titleLocator = By.xpath("//h3[contains(@class,'cds-CommonCard-title css-6ecy9b')] | //a[@data-click-key='search.search.click.search_card']");

    public String verification() {
        log.info("PAGE: Printing the first course title in the console");
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator)).getText();
        return title;
    }
}
