package com.automationexercise.action.page;

import com.automationexercise.page.TestCasesPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCasesPageAction {

    private TestCasesPage page;

    public void verifyVisible() {
        assertThat(this.page.getTestCasesHeader().isVisible()).isTrue();
    }

}
