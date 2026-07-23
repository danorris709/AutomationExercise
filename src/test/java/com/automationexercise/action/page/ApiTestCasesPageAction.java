package com.automationexercise.action.page;

import com.automationexercise.page.APITestCasesPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTestCasesPageAction {

    private APITestCasesPage page;

    public void verifyVisible() {
        assertThat(this.page.getApiTestingHeader().isVisible()).isTrue();
    }

}
