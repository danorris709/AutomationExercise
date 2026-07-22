package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.SignupPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SignupPageStep {

    @Steps
    private SignupPageAction signupPageAction;

    @Then("I should be prompted to \"ENTER ACCOUNT INFORMATION\"")
    public void enterAccountInfo() {
        this.signupPageAction.checkSignupIsVisible();
    }

    @When("I complete the registration details")
    public void fillRegistrationDetails() {
        this.signupPageAction.fillRegistrationPageValues();
    }

    @When("I signup for the newsletter")
    public void signupForNewsletter() {
        this.signupPageAction.signupForNewsletter();
    }

    @When("I signup for the special offers")
    public void signupForSpecialOffers() {
        this.signupPageAction.signupForSpecialOffers();
    }

    @When("I click the create account button")
    public void createAccount() {
        this.signupPageAction.createAccount();
    }
}
