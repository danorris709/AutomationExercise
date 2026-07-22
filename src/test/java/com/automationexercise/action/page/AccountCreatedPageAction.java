package com.automationexercise.action.page;

import com.automationexercise.page.AccountCreatedPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountCreatedPageAction {

    private AccountCreatedPage page;

    @Step("Verify page is visible")
    public void verifyPageIsVisible() {
        assertThat(this.page.getAccountCreatedText().isVisible()).isTrue();
    }

    @Step("Leave page")
    public void continueToNextPage() {
        this.page.proceedFromPage();
    }
}
