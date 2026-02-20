package com.coursera.stepdefs;

import com.coursera.base.DriverFactory;
import com.coursera.pages.HomePage;
import com.coursera.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CourseSearchSteps{

    @Given("User is on the Home page")
    public void user_is_on_the_home_page() {
        //user is on the home page
    }
    @When("User search a {string} in the search input")
    public void user_search_a_in_the_search_input(String keyWord) {
        HomePage hp = new HomePage(DriverFactory.getDriver());
        hp.search(keyWord);
    }
    @Then("Validate the title of the first course contains the {string}")
    public void validate_the_title_of_the_first_course_contains_the(String keyWord) {
        SearchResultPage srp = new SearchResultPage(DriverFactory.getDriver());
        String title = srp.verification();
        Assert.assertTrue(title.contains(keyWord),title+" contains the "+keyWord+", so test PASSED");
    }
}
