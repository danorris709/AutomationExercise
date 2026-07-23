package com.automationexercise.page;

import com.automationexercise.api.CartItem;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://automationexercise.com/view_cart")
public class CartPage extends AutomationExercisePage {

    @FindBy(css = ".btn.check_out")
    private WebElementFacade checkoutButton;

    public List<CartItem> getCartItems() {
        List<CartItem> parsedItems = new ArrayList<>();
        var rows = this.getAllCartElements();

        for (var row : rows) {
            var name = row.find(By.cssSelector(".cart_description h4 a")).getText().trim();
            var rawPrice = row.find(By.cssSelector(".cart_price p")).getText().trim();
            var rawQuantity = row.find(By.cssSelector(".cart_quantity button")).getText().trim();
            var rawTotal = row.find(By.cssSelector(".cart_total_price")).getText().trim();

            parsedItems.add(new CartItem(name, rawPrice, rawQuantity, rawTotal));
        }

        return parsedItems;
    }

    public List<WebElementFacade> getAllCartElements() {
        return findAll(By.cssSelector("#cart_info_table tbody tr"));
    }

    public WebElementFacade getCheckoutButton() {
        return this.checkoutButton;
    }
}
