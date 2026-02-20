package com.coursera.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.coursera.stepdefs"},
        monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
