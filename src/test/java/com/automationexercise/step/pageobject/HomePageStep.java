package com.automationexercise.step.pageobject;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.api.NavBar;
import com.automationexercise.action.page.HomePageAction;
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

    @When("I navigate to the {navbar} page")
    public void clickSignUpLoginButton(NavBar navBar) {
        this.homePageAction.clickNavBar(navBar.position());
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

    @When("I click to logout")
    public void logout() {
        this.homePageAction.clickNavBar(3);
    }
}
