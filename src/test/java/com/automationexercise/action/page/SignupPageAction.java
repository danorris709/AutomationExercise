package com.automationexercise.action.page;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.page.SignupPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignupPageAction {

    private SignupPage signupPage;

    @Step("Verify New User Signup is visible")
    public void checkSignupIsVisible() {
        assertThat(this.signupPage.getLoginForm().isVisible()).isTrue();
    }

    @Step("Fill registration page values")
    public void fillRegistrationPageValues() {
        var account = AutomationExerciseTestSuite.getAccountContext().getDraft();
        this.signupPage.fillDetails(account);
    }

    @Step("Confirm newsletter signup")
    public void signupForNewsletter() {
        this.signupPage.confirmNewsLetter();
    }

    @Step("Confirm special offers signup")
    public void signupForSpecialOffers() {
        this.signupPage.confirmSpecialOffers();
    }

    @Step("Click create account button")
    public void createAccount() {
        this.signupPage.submitForm();

        var draft = AutomationExerciseTestSuite.getAccountContext().getDraft();
        AutomationExerciseTestSuite.getAccountContext().registerAccount(draft.toAccount());
    }


}
