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

    @Then("I should see the \"Login to your account\" form")
    public void seeLoginForm() {
        this.loginPageAction.checkLoginIsVisible();
    }

    @When("I start the signup process")
    public void beginSignUp() {
        this.loginPageAction.startSignupProcess();
    }

    @When("I login with my email and password")
    public void enterEmailAndPassword() {
        this.loginPageAction.loginWithEmailAndPassword();
    }
}
