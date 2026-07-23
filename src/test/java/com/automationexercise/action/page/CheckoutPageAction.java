package com.automationexercise.action.page;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.api.CheckoutAddressModel;
import com.automationexercise.page.CheckoutPage;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutPageAction {

    private CheckoutPage page;

    @Step("Verifies the delivery address on the page matches the account information")
    public void verifyDeliveryAddressIsCorrect() {
        var pageInfo = this.page.getDisplayedDeliveryAddress();
        this.verifyUserDataMatches(pageInfo);
    }

    @Step("Verifies the billing address on the page matches the account information")
    public void verifyBillingAddressIsCorrect() {
        var pageInfo = this.page.getDisplayedBillingAddress();
        this.verifyUserDataMatches(pageInfo);
    }

    private void verifyUserDataMatches(CheckoutAddressModel pageInfo) {
        var account = AutomationExerciseTestSuite.getAccountContext().getAccount();
        var properties = account.properties();

        String expectedFullName = properties.get("title") + ". " + properties.get("name");
        String expectedCityStateZip = String.format("%s %s %s",
                properties.get("city"),
                properties.get("state"),
                properties.get("zipcode")
        );

        assertThat(pageInfo.fullName()).isEqualTo(expectedFullName);
        assertThat(pageInfo.company()).isEqualTo(properties.get("company"));
        assertThat(pageInfo.address1()).isEqualTo(properties.get("address1"));
        assertThat(pageInfo.address2()).isEqualTo(properties.get("address2"));
        assertThat(pageInfo.cityStateZip()).isEqualTo(expectedCityStateZip);
        assertThat(pageInfo.country()).isEqualTo(properties.get("country"));
        assertThat(pageInfo.phone()).isEqualTo(properties.get("mobile_number"));
    }


}
