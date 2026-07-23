package com.automationexercise.action.page;

import com.automationexercise.page.CartPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartPageAction {

    private CartPage cartPage;

    @Step("Verify there is {0} items in the cart")
    public void verifyThereIsItemsInCart(int items) {
        assertThat(this.cartPage.getCartItems().size()).isEqualTo(items);
    }

    @Step("The total price matches the individual prices")
    public void verifyTotalPricesCorrect() {
        for (var cartItem : this.cartPage.getCartItems()) {
            assertThat(cartItem.total()).isEqualTo(cartItem.price() * cartItem.quantity());
        }
    }
}
