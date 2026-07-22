package com.automationexercise.page;

import com.automationexercise.api.AccountDraft;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/signup")
public class SignupPage extends PageObject {

    @FindBy(id = "id_gender1")
    private WebElementFacade genderMr;

    @FindBy(id = "id_gender2")
    private WebElementFacade genderMrs;

    @FindBy(id = "name")
    private WebElementFacade nameInput;

    @FindBy(id = "email")
    private WebElementFacade emailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "days")
    private WebElementFacade daysDropdown;

    @FindBy(id = "months")
    private WebElementFacade monthsDropdown;

    @FindBy(id = "years")
    private WebElementFacade yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElementFacade newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElementFacade specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "last_name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "company")
    private WebElementFacade companyInput;

    @FindBy(id = "address1")
    private WebElementFacade address1Input;

    @FindBy(id = "address2")
    private WebElementFacade address2Input;

    @FindBy(id = "country")
    private WebElementFacade countryDropdown;

    @FindBy(id = "state")
    private WebElementFacade stateInput;

    @FindBy(id = "city")
    private WebElementFacade cityInput;

    @FindBy(id = "zipcode")
    private WebElementFacade zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElementFacade mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElementFacade createAccountButton;

    @FindBy(className = "login-form")
    private WebElementFacade loginForm;

    public WebElementFacade getLoginForm() {
        return this.loginForm;
    }

    public void fillDetails(AccountDraft draft) {
        var props = draft.properties();

        String title = props.get("title");
        if ("Mr".equalsIgnoreCase(title)) {
            genderMr.click();
        } else if ("Mrs".equalsIgnoreCase(title) || "Miss".equalsIgnoreCase(title)) {
            genderMrs.click();
        }

        if (props.containsKey("name") && nameInput.isCurrentlyEnabled()) {
            nameInput.type(props.get("name"));
        }
        if (props.containsKey("password")) {
            passwordInput.type(props.get("password"));
        }

        if (props.containsKey("birth_date")) {
            daysDropdown.selectByValue(props.get("birth_date"));
        }
        if (props.containsKey("birth_month")) {
            monthsDropdown.selectByVisibleText(props.get("birth_month"));
        }
        if (props.containsKey("birth_year")) {
            yearsDropdown.selectByValue(props.get("birth_year"));
        }

        firstNameInput.type(props.getOrDefault("firstname", ""));
        lastNameInput.type(props.getOrDefault("lastname", ""));
        companyInput.type(props.getOrDefault("company", ""));
        address1Input.type(props.getOrDefault("address1", ""));
        address2Input.type(props.getOrDefault("address2", ""));

        if (props.containsKey("country")) {
            countryDropdown.selectByVisibleText(props.get("country"));
        }

        stateInput.type(props.getOrDefault("state", ""));
        cityInput.type(props.getOrDefault("city", ""));
        zipcodeInput.type(props.getOrDefault("zipcode", ""));
        mobileNumberInput.type(props.getOrDefault("mobile_number", ""));
    }

    public void confirmNewsLetter() {
        this.newsletterCheckbox.click();
    }

    public void confirmSpecialOffers() {
        this.specialOffersCheckbox.click();
    }

    public void submitForm() {
        createAccountButton.click();
    }
}
