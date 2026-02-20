package com.coursera.stepdefs;

import com.coursera.base.DriverFactory;
import com.coursera.pages.HomePage;
import com.coursera.pages.PythonPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LevelValidationSteps {

    HomePage hp = new HomePage(DriverFactory.getDriver());
    PythonPage pp = new PythonPage(DriverFactory.getDriver());

    @When("User navigate to explore page")
    public void user_navigate_to_explore_page() {
        hp.hoverExplore();
    }

    @When("Click {string} link")
    public void click_link(String category) {
        hp.selectPython(category);
    }

    @When("Select the first course")
    public void select_the_first_course() {
        pp.selectCourse();
    }

    @Then("validate if the page contains {string} in it")
    public void validate_if_the_page_contains_in_it(String levelText) {
        String level = pp.extractLevel();
        Assert.assertTrue(level.toLowerCase().contains(levelText),"Course level is "+ level+". So test is PASSED");
    }
}
