package com.client.automationpractice.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/usoDeCarritoCompras.feature"},
        glue = {"com.client.automationpractice.test.stepdefinition.usocarritocompras"},
        tags = "",
        publish = true
)
public class UsoCarritoComprasTestRunner {

}
