package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.TestCasesPageAction;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class TestCasesPageStep {

    @Steps
    private TestCasesPageAction testCasesPageAction;

    @Then("I should see the list of test cases")
    public void verifyTestCasesVisible() {
        this.testCasesPageAction.verifyVisible();
    }

}
