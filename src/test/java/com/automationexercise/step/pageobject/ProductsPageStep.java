package com.automationexercise.step.pageobject;

import com.automationexercise.action.page.ProductsPageAction;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;
import java.util.regex.Pattern;

public class ProductsPageStep {

    private static final Pattern POSITION_PATTERN = Pattern.compile("([0-9]+)(nd|st|rd|th)?");

    @Steps
    private ProductsPageAction action;

    @When("I add the following products to my cart:")
    public void addProductsToCart(List<String> productPositions) {
        for (var position : productPositions) {
            var index = this.convertPositionToIndex(position);

            this.action.addProductToCart(index);
        }
    }

    private int convertPositionToIndex(String position) {
        var compiledPattern = POSITION_PATTERN.matcher(position);

        if (!compiledPattern.find()) {
            throw new IllegalArgumentException("Invalid product position format provided");
        }

        var number = compiledPattern.group(1);

        return Integer.parseInt(number) - 1;
    }
}
