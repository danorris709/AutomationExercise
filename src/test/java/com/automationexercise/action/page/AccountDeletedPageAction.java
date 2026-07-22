package com.automationexercise.action.page;

import com.automationexercise.page.AccountDeletedPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountDeletedPageAction {

    private AccountDeletedPage page;

    @Step("Verify page is visible")
    public void verifyPageIsVisible() {
        assertThat(this.page.getAccountDeletedText().isVisible()).isTrue();
    }

    @Step("Leave page")
    public void continueToNextPage() {
        this.page.proceedFromPage();
    }
}
