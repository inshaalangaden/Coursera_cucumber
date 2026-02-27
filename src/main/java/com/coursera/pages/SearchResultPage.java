package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }
    @Web(xpath="//div[@data-e2e='NumberOfResultsSection']/span")
    private WebElement resultElement;

    public String verification() {
        log.info("PAGE: Printing the first course title in the console");
        String title = getText(resultElement);
        return title;
    }
}
