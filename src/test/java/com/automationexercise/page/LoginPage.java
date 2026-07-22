package com.automationexercise.page;


import com.automationexercise.api.AccountDraft;
import com.automationexercise.api.UserAccount;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends AutomationExercisePage {

    @FindBy(css = "[data-qa=\"signup-name\"]")
    private WebElementFacade signupNameBox;

    @FindBy(css = "[data-qa=\"signup-email\"]")
    private WebElementFacade signupEmailBox;

    @FindBy(css = "[data-qa=\"signup-button\"]")
    private WebElementFacade signupButton;


    @FindBy(css = "[data-qa=\"login-email\"]")
    private WebElementFacade loginEmailBox;

    @FindBy(css = "[data-qa=\"login-password\"]")
    private WebElementFacade loginPasswordBox;

    @FindBy(css = "[data-qa=\"login-button\"]")
    private WebElementFacade loginButton;

    @FindBy(className = "signup-form")
    private WebElementFacade signupForm;

    @FindBy(className = "login-form")
    private WebElementFacade loginForm;

    @FindBy(css = ".login-form form p[style*='color: red']")
    private WebElementFacade incorrectEmailOrPassword;

    public void beginSignUp(AccountDraft draft) {
        this.signupNameBox.type(draft.name());
        this.signupEmailBox.type(draft.email());
        this.signupButton.click();
    }

    public void loginToAccount(UserAccount account) {
        this.loginEmailBox.type(account.email());
        this.loginPasswordBox.type(account.password());
        this.loginButton.click();
    }

    public WebElementFacade getSignupForm() {
        return this.signupForm;
    }

    public WebElementFacade getLoginForm() {
        return this.loginForm;
    }

    public WebElementFacade getIncorrectEmailOrPassword() {
        return this.incorrectEmailOrPassword;
    }

}
