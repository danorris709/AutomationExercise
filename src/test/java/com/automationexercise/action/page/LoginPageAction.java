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

    @Step("Start signup process")
    public void startSignupProcess() {
        this.loginPage.beginSignUp(AutomationExerciseTestSuite.getAccountContext().getDraft());
    }

    @Step("Login with email and password")
    public void loginWithEmailAndPassword() {
        var account = AutomationExerciseTestSuite.getAccountContext().getAccount();
        this.loginPage.loginToAccount(account);
    }

}
