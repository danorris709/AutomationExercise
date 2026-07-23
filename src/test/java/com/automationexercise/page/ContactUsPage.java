package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Paths;

@DefaultUrl("https://automationexercise.com/contact_us")
public class ContactUsPage extends AutomationExercisePage {

    @FindBy(id = "contact-us-form")
    private WebElementFacade contactForm;

    @FindBy(css = "[data-qa=\"name\"]")
    private WebElementFacade nameBox;

    @FindBy(css = "[data-qa=\"email\"]")
    private WebElementFacade emailBox;

    @FindBy(css = "[data-qa=\"subject\"]")
    private WebElementFacade subjectBox;

    @FindBy(css = "[data-qa=\"message\"]")
    private WebElementFacade messageBox;

    @FindBy(css = "[data-qa=\"submit-button\"]")
    private WebElementFacade submitButton;

    @FindBy(name = "upload_file")
    private WebElementFacade fileUpload;

    @FindBy(css = "div.status.alert.alert-success")
    private WebElementFacade successMessage;

    @FindBy(css = "a.btn-success[href='/']")
    private WebElementFacade homeButton;

    public WebElementFacade getContactForm() {
        return this.contactForm;
    }

    public WebElementFacade getSuccessMessage() {
        return successMessage;
    }

    public void fillNameAndEmail(String name, String email) {
        this.nameBox.type(name);
        this.emailBox.type(email);
    }

    public void fillSubject(String subject) {
        this.subjectBox.type(subject);
    }

    public void inputMessage(String message) {
        this.messageBox.type(message);
    }

    public void uploadFile(String relativeFilePath) {
        var file = Paths.get("src/test/resources/", relativeFilePath).toFile();
        String absolutePath = file.getAbsolutePath();

        this.fileUpload.type(absolutePath);
    }

    public void submitForm() {
        this.submitButton.click();
    }

    public void acceptConfirmationAlert() {
        var alert = this.getAlert();
        alert.accept();
    }

    public void returnHome() {
        this.homeButton.click();
    }

}
