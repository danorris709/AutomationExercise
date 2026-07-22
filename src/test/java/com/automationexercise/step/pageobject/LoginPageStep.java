package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.LoginPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginPageStep {

    @Steps
    private LoginPageAction loginPageAction;

    @Then("I should see the \"New User Signup!\" form")
    public void seeSignUpPage() {
        this.loginPageAction.checkSignupIsVisible();
    }

    @When("I start the signup process")
    public void beginSignUp() {
        this.loginPageAction.startSignupProcess();
    }
}
