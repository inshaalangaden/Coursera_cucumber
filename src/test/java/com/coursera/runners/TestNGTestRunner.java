package com.coursera.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "src/test/java/com/coursera/stepdefs",
        monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
