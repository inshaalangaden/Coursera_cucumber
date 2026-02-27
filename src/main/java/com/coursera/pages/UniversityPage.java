package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import com.coursera.utils.WebInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UniversityPage extends BasePage {
    public UniversityPage(WebDriver driver){
        super(driver);
        WebInitializer.init(driver,this);
    }

    @Web(css = "a[data-click-key='ent_website._campus.click.navigation_priority_cta']")
    WebElement contactUs;

    public void clickContactUs(){
        log.info("PAGE: Click contactUs button");
        contactUs.click();
    }

}
