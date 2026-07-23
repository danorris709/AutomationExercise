package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.ContactUsPageAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ContactUsPageStep {

    @Steps
    private ContactUsPageAction contactUsPageAction;

    @Then("I should see the get in touch form")
    public void verifyGetInTouchForm() {
        this.contactUsPageAction.verifyContactFormIsVisible();
    }

    @When("I fill in the contact details with {string} and {string}")
    public void fillInDetails(String name, String email) {
        this.contactUsPageAction.submitNameAndEmail(name, email);
    }

    @When("I fill in the subject with {string}")
    public void fillInSubject(String message) {
        this.contactUsPageAction.submitSubject(message);
    }

    @When("I fill in the message with {string}")
    public void fillInMessage(String message) {
        this.contactUsPageAction.submitMessage(message);
    }

    @When("I upload a test file {string}")
    public void uploadTestFile(String path) {
        this.contactUsPageAction.uploadFile(path);
    }

    @When("I click to submit")
    public void submitForm() {
        this.contactUsPageAction.submitContactUsForm();
    }

    @When("I click the OK button")
    public void acceptConfirmationAlert() {
        this.contactUsPageAction.acceptAlert();
    }

    @Then("I should see the success message")
    public void verifySuccess() {
        this.contactUsPageAction.verifySuccessMessageIsVisible();
    }

    @When("I click the home button")
    public void clickHomeButton() {
        this.contactUsPageAction.returnHome();
    }

}
