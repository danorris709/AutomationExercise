package com.automationexercise.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AutomationExercisePage extends PageObject {

    public static final String CURRENT_PAGE_COLOUR = "rgba(255, 165, 0, 1)";

    @FindBy(id = "header")
    private WebElementFacade header;

    public WebElementFacade getNavBarElement(int index) {
        return this.getNavBarElements().get(index);
    }

    public List<WebElementFacade> getNavBarElements() {
        var navBar = this.getNavBar();
        return navBar.thenFindAll(By.tagName("li"));
    }

    public WebElementFacade getNavBar() {
        var header = this.header();
        return header.find(By.cssSelector("ul.nav.navbar-nav"));
    }

    public WebElementFacade header() {
        return this.header;
    }

}
