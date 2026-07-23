package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/test_cases")
public class TestCasesPage extends AutomationExercisePage {

    @FindBy(css = "#form h2.title b")
    private WebElementFacade testCasesHeader;

    public WebElementFacade getTestCasesHeader() {
        return this.testCasesHeader;
    }
}
