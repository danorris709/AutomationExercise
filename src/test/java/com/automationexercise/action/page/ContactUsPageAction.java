package com.automationexercise.action.page;

import com.automationexercise.page.ContactUsPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactUsPageAction {

    private ContactUsPage page;

    @Step("Verify contact form is visible")
    public void verifyContactFormIsVisible() {
        assertThat(this.page.getContactForm().isVisible()).isTrue();
    }

    @Step("Verify success message is visible")
    public void verifySuccessMessageIsVisible() {
        assertThat(this.page.getSuccessMessage().isVisible()).isTrue();
    }

    @Step("Submit name ({0}) and email ({1})")
    public void submitNameAndEmail(String name, String email) {
        this.page.fillNameAndEmail(name, email);
    }

    @Step("Submit subject {0}")
    public void submitSubject(String subject) {
        this.page.fillSubject(subject);
    }

    @Step("Submit message {0}")
    public void submitMessage(String message) {
        this.page.inputMessage(message);
    }

    @Step("Upload file {0}")
    public void uploadFile(String file) {
        this.page.uploadFile(file);
    }

    @Step("Submit contact us form")
    public void submitContactUsForm() {
        this.page.submitForm();
    }

    @Step("Accept alert")
    public void acceptAlert() {
        this.page.acceptConfirmationAlert();
    }

    @Step("Return to home page")
    public void returnHome() {
        this.page.returnHome();
    }



}
