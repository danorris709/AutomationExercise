package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.CheckoutPageAction;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class CheckoutPageStep {
    @Steps
    private CheckoutPageAction action;

    @Then("the billing address should be correct")
    public void validateBillingAddress() {
        this.action.verifyBillingAddressIsCorrect();
    }

    @Then("the delivery address should be correct")
    public void validateDeliveryAddress() {
        this.action.verifyDeliveryAddressIsCorrect();
    }

}
