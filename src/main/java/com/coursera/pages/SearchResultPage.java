package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import com.coursera.utils.WebInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
        WebInitializer.init(driver,this);
    }
    @Web(xpath="//div[@data-e2e='NumberOfResultsSection']/span")
    private WebElement resultElement;

    //By titleLocator = By.xpath("//h3[contains(@class,'cds-CommonCard-title css-6ecy9b')] | //a[@data-click-key='search.search.click.search_card']");

    public String verification() {
        log.info("PAGE: Printing the first course title in the console");
        String title = wait.until(ExpectedConditions.visibilityOf(resultElement)).getText();
        return title;
    }
}
