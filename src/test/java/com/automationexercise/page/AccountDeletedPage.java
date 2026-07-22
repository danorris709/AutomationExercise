package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/delete_account")
public class AccountDeletedPage extends AutomationExercisePage {

    @FindBy(css = "[data-qa=\"account-deleted\"]")
    private WebElementFacade accountDeletedText;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    private WebElementFacade continueButton;

    public WebElementFacade getAccountDeletedText() {
        return this.accountDeletedText;
    }

    public void proceedFromPage() {
        this.continueButton.click();
    }
}
