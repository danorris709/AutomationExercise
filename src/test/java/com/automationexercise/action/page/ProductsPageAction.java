package com.automationexercise.action.page;

import com.automationexercise.page.ProductsPage;
import net.serenitybdd.annotations.Step;

public class ProductsPageAction {

    private ProductsPage page;

    @Step("Add product to the cart")
    public void addProductToCart(int index) {
        this.page.hoverAndAddProductToCart(index);
        this.page.clickContinueShopping();
    }

    @Step("Click continue shopping")
    public void clickContinueShopping() {
        this.page.clickContinueShopping();
    }
}
