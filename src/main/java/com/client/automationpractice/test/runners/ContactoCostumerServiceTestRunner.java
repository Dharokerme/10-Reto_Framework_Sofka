package com.client.automationpractice.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactoCostumerService.feature"},
        glue = {"com.client.automationpractice.test.stepdefinition.contactocostumerservice"},
        tags = "",
        publish = true
)
public class ContactoCostumerServiceTestRunner {
}
