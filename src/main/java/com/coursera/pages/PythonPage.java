package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import com.coursera.utils.WebInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PythonPage extends BasePage {
    public PythonPage(WebDriver driver){
        super(driver);
        WebInitializer.init(driver,this);
    }

    @Web(css="div.cds-CommonCard-clickArea:first-of-type")
    private WebElement pythonCourse;

    @Web(xpath="//div[@class='css-6mrk5o']//div[contains(text(),'level')] | (//div[contains(@class, 'css-fk6qfz') and contains(text(), 'level')])[2]")
    private WebElement levelElement;

    //By levelLocator = By.xpath("//div[@class='css-6mrk5o']//div[contains(text(),'level')] | (//div[contains(@class, 'css-fk6qfz') and contains(text(), 'level')])[2]");

    public void selectCourse(){
        log.info("PAGE: Click the first course");
        wait.until(ExpectedConditions.visibilityOf(pythonCourse));
        wait.until(ExpectedConditions.elementToBeClickable(pythonCourse)).click();
    }

    public void switchTab(){
        log.info("PAGE: Switching tab after clicking first Python course");
        String current_tab = driver.getWindowHandle();
        for(String handle: driver.getWindowHandles()){
            if(!(handle.equals(current_tab))){
                driver.switchTo().window(handle);
            }
        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public String extractLevel(){
        log.info("PAGE: Printing the level of the course in console");
        wait.until(ExpectedConditions.textToBePresentInElement(levelElement,"level"));
        String level = levelElement.getText();
        return level;
    }
}
