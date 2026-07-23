package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.CartPageAction;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class CartPageStep {

    @Steps
    private CartPageAction action;

    @Then("the total price should match the individual price")
    public void verifyTotalPrices() {
        this.action.verifyTotalPricesCorrect();
    }

    @Then("I should see {int} products in my cart")
    public void verifyCartSize(int size) {
        this.action.verifyThereIsItemsInCart(size);
    }
}
