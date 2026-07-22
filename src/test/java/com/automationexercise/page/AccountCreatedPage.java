package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/account_created")
public class AccountCreatedPage extends AutomationExercisePage {

    @FindBy(css = "[data-qa=\"account-created\"]")
    private WebElementFacade accountCreatedText;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    private WebElementFacade continueButton;

    public WebElementFacade getAccountCreatedText() {
        return this.accountCreatedText;
    }

    public void proceedFromPage() {
        this.continueButton.click();
    }
}
