package com.automationexercise.action.page;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.page.LoginPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPageAction {

    private LoginPage loginPage;

    @Step("Verify New User Signup is visible")
    public void checkSignupIsVisible() {
        assertThat(this.loginPage.getSignupForm().isVisible()).isTrue();
    }

    @Step("Verify User Login is visible")
    public void checkLoginIsVisible() {
        assertThat(this.loginPage.getLoginForm().isVisible()).isTrue();
    }

    @Step("Verify incorrect email or password error is visible")
    public void verifyIncorrectEmailOrPasswordError() {
        assertThat(this.loginPage.getIncorrectEmailOrPassword().isVisible()).isTrue();
    }

    @Step("Verify email address already exists error is visible")
    public void verifyEmailAddressAlreadyExists() {
        assertThat(this.loginPage.getEmailAddressAlreadyExists().isVisible()).isTrue();
    }

    @Step("Start signup process")
    public void startSignupProcess() {
        this.loginPage.beginSignUp(AutomationExerciseTestSuite.getAccountContext().getDraft());
    }

    @Step("Start signup process with registered account")
    public void startSignupProcessWithRegisteredAccount() {
        var account = AutomationExerciseTestSuite.getAccountContext().getAccount();
        this.loginPage.beginSignUp(account.toDraft());
    }

    @Step("Login with email and password")
    public void loginWithEmailAndPassword() {
        var account = AutomationExerciseTestSuite.getAccountContext().getAccount();
        this.loginPage.loginToAccount(account);
    }

}
