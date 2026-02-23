package com.coursera.stepdefs;

import com.coursera.base.DriverFactory;
import com.coursera.pages.FormPage;
import com.coursera.pages.HomePage;
import com.coursera.pages.UniversityPage;
import com.coursera.utils.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class FormValidationSteps {
    FormPage fp = new FormPage(DriverFactory.getDriver());

    private String sNo, fName, lName, mail, phone, instType, instName, role, dpmt, need, cntry, testType;

    private boolean testPassed;
    private String resultMessage;

    private final String filePath = System.getProperty("user.dir") + "/src/main/resources/formData.xlsx";
    private final String sheetName = "Sheet1";

    private int currentRow;

    @When("User navigate to forUniversities page")
    public void userNavigateToForUniversitiesPage() {
        HomePage hp = new HomePage(DriverFactory.getDriver());
        hp.navigateToUniversities();
    }

    @And("User clicked ContactUs button")
    public void userClickedContactUsButton() {
        UniversityPage up = new UniversityPage(DriverFactory.getDriver());
        up.clickContactUs();
    }

    @And("fill the form with excel row {string}")
    public void fillTheFormWithExcelRow(String rowNo) throws IOException {

        int rowIndex = Integer.parseInt(rowNo)-1;
        currentRow = Integer.parseInt(rowNo);
        System.out.println("current row = "+currentRow);

        Object[][] data = ExcelUtils.getTestData(filePath,sheetName);
        Object[] row = data[rowIndex];

        sNo = safe(row[0]);
        fName = safe(row[1]);
        lName = safe(row[2]);
        mail = safe(row[3]);
        phone = safe(row[4]);
        instType = safe(row[5]);
        instName = safe(row[6]);
        role = safe(row[7]);
        dpmt = safe(row[8]);
        need = safe(row[9]);
        cntry = safe(row[10]);
        testType = safe(row[11]);

        fp.fillForm(fName, lName, mail, phone, instType, instName, role, dpmt, need, cntry);
        fp.clickSubmit();

    }

    @Then("validate alert behavior based on the excel Test Type")
    public void validateAlertBehaviorBasedOnTheExcelTestType() throws IOException {
        boolean alertPresent = fp.isAlertPresent();

        if(testType.equalsIgnoreCase("positive")) testPassed = !alertPresent;
        else testPassed = alertPresent;

        ExcelUtils.setCellData(filePath, sheetName, currentRow, resultMessage,DriverFactory.getBrowser());

        Assert.assertTrue(testPassed, resultMessage);
    }

    private String safe(Object obj){
        return obj == null ? "" : obj.toString().trim();
    }
}
