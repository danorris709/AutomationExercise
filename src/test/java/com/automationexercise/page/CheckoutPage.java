package com.automationexercise.page;

import com.automationexercise.api.CheckoutAddressModel;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://automationexercise.com/checkout")
public class CheckoutPage extends AutomationExercisePage {

    @FindBy(id = "address_delivery")
    private WebElementFacade deliveryAddressContainer;

    @FindBy(id = "address_invoice")
    private WebElementFacade billingAddressContainer;

    public CheckoutAddressModel getDisplayedDeliveryAddress() {
        return this.getAddressModel(this.deliveryAddressContainer);
    }

    public CheckoutAddressModel getDisplayedBillingAddress() {
        return this.getAddressModel(this.billingAddressContainer);
    }

    private CheckoutAddressModel getAddressModel(WebElementFacade container) {
        var fullName = container.find(By.cssSelector(".address_firstname.address_lastname")).getText().trim();
        var addressLines = container.thenFindAll(
                By.cssSelector(".address_address1.address_address2")
        );

        String company = "";
        String address1 = "";
        String address2 = "";

        if (addressLines.size() == 3) {
            company = addressLines.get(0).getText().trim();
            address1 = addressLines.get(1).getText().trim();
            address2 = addressLines.get(2).getText().trim();
        } else if (addressLines.size() == 2) {
            address1 = addressLines.get(0).getText().trim();
            address2 = addressLines.get(1).getText().trim();
        } else if (addressLines.size() == 1) {
            address1 = addressLines.getFirst().getText().trim();
        }

        var cityStateZip = deliveryAddressContainer.find(
                By.cssSelector(".address_city.address_state_name.address_postcode")
        ).getText().trim();

        var country = deliveryAddressContainer.find(By.cssSelector(".address_country_name")).getText().trim();
        var phone = deliveryAddressContainer.find(By.cssSelector(".address_phone")).getText().trim();

        return new CheckoutAddressModel(fullName, company, address1, address2, cityStateZip, country, phone);
    }
}
