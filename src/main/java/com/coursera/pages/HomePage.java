package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }

    //Web elements
    @Web(id="search-autocomplete-input")
    private WebElement searchInput;

    @Web(xpath="//button[@data-testid='megamenu-explore-button']")
    private WebElement exploreButton;

    @Web(xpath="//a[@data-track-href='/courses?query=python'] | //a[@to='/courses?query=python'] | //a[@href='/courses?query=python']")
    private WebElement pythonLink;

    @Web(xpath = "//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Campus']")
    private WebElement forUniversities;


    //Methods
    public void search(String text){
        log.info("PAGE: Searching for: {}", text);
        type(searchInput,text);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void hoverExplore(){
        log.info("PAGE: Hover over explore link");
        Actions action = new Actions(driver);
        action.moveToElement(exploreButton).perform();
    }

    public void selectPython(String category){
        log.info("PAGE: Selecting "+category+" from explore");
        click(pythonLink);
    }

    public void navigateToUniversities(){
        log.info("PAGE: Navigating to forUniversities page");
        click(forUniversities);
    }
}
