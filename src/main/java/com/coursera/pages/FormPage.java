package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import com.coursera.utils.WebInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class FormPage extends BasePage {


    public FormPage(WebDriver driver){
        super(driver);
        WebInitializer.init(driver,this);
    }

    @Web(id="FirstName")
    private WebElement firstName;

    @Web(id="LastName")
    private WebElement lastName;

    @Web(id="Email")
    private WebElement email;

    @Web(id="Phone")
    private WebElement phoneNumber;

    @Web(id="Institution_Type__c")
    private WebElement institutionType;

    @Web(id="Company")
    private WebElement institutionName;

    @Web(id="Title")
    private WebElement jobRole;

    @Web(id="Department")
    private WebElement department;

    @Web(id="Self_Reported_Needs__c")
    private WebElement needs;

    @Web(id="Country")
    private WebElement country;

    @Web(css= "button[type='submit']")
    private WebElement submitButton;

    @Web(xpath="//div[@role='alert']")
    private List<WebElement> alertElement;


    public void fillForm(String fName, String lName, String mail, String phone, String instType, String instName, String role, String dpmt, String need, String cntry){
        log.info("PAGE: Filling the form");

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        phoneNumber.sendKeys(phone);
        institutionName.sendKeys(instName);

        Select s1 = new Select(institutionType);
        s1.selectByVisibleText(instType);

        Select s2 = new Select(jobRole);
        s2.selectByVisibleText(role);

        Select s3 = new Select(department);
        s3.selectByVisibleText(dpmt);

        Select s4 = new Select(needs);
        s4.selectByVisibleText(need);

        Select s5 = new Select(country);
        s5.selectByVisibleText(cntry);
    }

    public void clickSubmit(){
        log.info("PAGE: Click submit button");
        submitButton.click();
    }
    public boolean isAlertPresent(){
        log.info("PAGE: Return the alert");
        return !(alertElement.isEmpty()); //this can crash..BEWARE!!!!!
    }

    public String getAlert() {
        log.info("PAGE: Return alert message if the alert is present");

        if (isAlertPresent()) return alertElement.get(0).getText();
        else{
            return "No error present";
        }
    }
}
