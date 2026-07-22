package com.automationexercise.action.page;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.page.AutomationExercisePage;
import com.automationexercise.page.HomePage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageAction {

    private HomePage homePage;

    @Step("Open the home page")
    public void openHomePage() {
        this.homePage.open();
    }

    @Step("Check that the home page screen is displayed")
    public void shouldSeeHomePage() {
        var homePageElement = this.homePage.getNavBarElement(0);
        var link = homePageElement.find(By.tagName("a"));
        var color = link.getCssValue("color");

        assertThat(color).isEqualTo(AutomationExercisePage.CURRENT_PAGE_COLOUR);
    }

    @Step("Click nav bar element")
    public void clickNavBar(int index) {
        this.homePage.getNavBarElement(index).click();
    }

    @Step("Verify logged in")
    public void verifyLoggedIn() {
        var loggedInStatus = this.homePage.getNavBarElements().getLast();
        var account = AutomationExerciseTestSuite.getAccountContext().getAccount();

        assertThat(loggedInStatus.getText()).isEqualTo("Logged in as " + account.name());
    }

}
