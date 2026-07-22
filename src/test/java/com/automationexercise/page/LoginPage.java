package com.automationexercise.page;


import com.automationexercise.api.AccountDraft;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends AutomationExercisePage {

    @FindBy(css = "[data-qa=\"signup-name\"]")
    private WebElementFacade signUpNameBox;

    @FindBy(css = "[data-qa=\"signup-email\"]")
    private WebElementFacade signUpEmailBox;

    @FindBy(css = "[data-qa=\"signup-button\"]")
    private WebElementFacade signUpButton;

    @FindBy(className = "signup-form")
    private WebElementFacade signUpForm;

    public void beginSignUp(AccountDraft draft) {
        this.signUpNameBox.type(draft.name());
        this.signUpEmailBox.type(draft.email());
        this.signUpButton.click();
    }

    public WebElementFacade getSignUpForm() {
        return this.signUpForm;
    }

}
