package com.automationexercise.step.pageobject;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.action.page.HomePageAction;
import com.automationexercise.action.page.LoginPageAction;
import com.automationexercise.action.page.SignupPageAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomePageStep {

    @Steps
    private HomePageAction homePageAction;

    @Given("I am on the home page")
    public void openHomePage() {
        this.homePageAction.openHomePage();
    }

    @Then("I should see the home page")
    public void seeHomePage() {
        this.homePageAction.shouldSeeHomePage();
    }

    @When("I navigate to the Signup and Login page")
    public void clickSignUpLoginButton() {
        this.homePageAction.clickNavBar(3);
    }

    @Then("I should be logged in")
    public void confirmLoggedIn() {
        this.homePageAction.verifyLoggedIn();
    }

    @When("I click to delete my account")
    public void deleteAccount() {
        this.homePageAction.clickNavBar(4);
        AutomationExerciseTestSuite.getAccountContext().removeAccount();
    }
}
