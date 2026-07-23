package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://automationexercise.com/api_list")
public class APITestCasesPage extends AutomationExercisePage {

    @FindBy(css = "#form h2.title b")
    private WebElementFacade apiTestingHeader;

    public WebElementFacade getApiTestingHeader() {
        return this.apiTestingHeader;
    }
}
