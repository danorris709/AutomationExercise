package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.ApiTestCasesPageAction;
import com.automationexercise.action.page.TestCasesPageAction;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class ApiTestCasesPageStep {

    @Steps
    private ApiTestCasesPageAction testCasesPageAction;

    @Then("I should see the list of api test cases")
    public void verifyTestCasesVisible() {
        this.testCasesPageAction.verifyVisible();
    }

}
