package com.coursera.pages;

import com.coursera.annotations.Web;
import com.coursera.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FormPage extends BasePage {


    public FormPage(WebDriver driver){
        super(driver);
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

        type(firstName, fName);
        type(lastName, lName);
        type(email, mail);
        type(phoneNumber, phone);
        type(institutionName, instName);

        select(institutionType, instType);
        select(jobRole, role);
        select(department, dpmt);
        select(needs, need);
        select(country, cntry);

    }

    public void clickSubmit(){
        log.info("PAGE: Click submit button");
        click(submitButton);
    }
    public boolean isAlertPresent(){
        log.info("PAGE: Return the alert");
        return !(alertElement.isEmpty());
    }

    public String getAlert() {
        log.info("PAGE: Return alert message if the alert is present");

        if (isAlertPresent()) return getText(alertElement.get(0));
        else{
            return "No error present";
        }
    }
}
