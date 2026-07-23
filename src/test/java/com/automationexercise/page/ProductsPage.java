package com.automationexercise.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

@DefaultUrl("https://automationexercise.com/products")
public class ProductsPage extends AutomationExercisePage {

    @FindBy(css = ".features_items")
    private WebElementFacade featuresItemsContainer;

    @FindBy(css = "button.close-modal")
    private WebElementFacade continueShoppingButton;

    public List<WebElementFacade> getAllProducts() {
        return featuresItemsContainer.thenFindAll(By.cssSelector(".col-sm-4"));
    }

    public WebElementFacade getProductAt(int index) {
        var products = this.getAllProducts();

        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Requested product index " + index + " but page only contains " + products.size() + " products.");
        }

        return products.get(index);
    }

    public void hoverAndAddProductToCart(int index) {
        var productContainer = this.getProductAt(index);

        withAction().moveToElement(productContainer).perform();

        var addToCartButton = productContainer.find(By.cssSelector(".add-to-cart"));

        addToCartButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }
}
