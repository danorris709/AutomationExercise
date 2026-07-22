package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.AccountDeletedPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AccountDeletedPageStep {

    @Steps
    private AccountDeletedPageAction deletedPageAction;

    @Then("I should see the \"ACCOUNT DELETED!\" success screen")
    public void checkScreenVisible() {
        this.deletedPageAction.verifyPageIsVisible();
    }

    @When("I proceed from the account deleted screen")
    public void proceed() {
        this.deletedPageAction.continueToNextPage();
    }


}
