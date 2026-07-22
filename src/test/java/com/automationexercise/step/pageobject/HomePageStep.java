package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.HomePageAction;
import com.automationexercise.action.page.LoginPageAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomePageStep {

    @Steps
    private HomePageAction homePageAction;

    @Steps
    private LoginPageAction loginPageAction;

    @Given("I am on the home page")
    public void openHomePage() {
        this.homePageAction.openHomePage();
    }

    @Then("I should see the home page")
    public void seeHomePage() {
        this.homePageAction.shouldSeeHomePage();
    }

    @When("I click the sign up and login button")
    public void clickSignUpLoginButton() {
        this.homePageAction.clickNavBar(3);
    }

    @Then("I should see the new user sign up page")
    public void seeSignUpPage() {
        this.loginPageAction.checkSignUpTextIsVisible();
    }

}
