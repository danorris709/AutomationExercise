package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.AccountCreatedPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AccountCreatedPageStep {

    @Steps
    private AccountCreatedPageAction createdPageAction;

    @Then("I should see the \"ACCOUNT CREATED!\" success screen")
    public void checkScreenVisible() {
        this.createdPageAction.verifyPageIsVisible();
    }

    @When("I proceed from the account created screen")
    public void proceed() {
        this.createdPageAction.continueToNextPage();
    }


}
