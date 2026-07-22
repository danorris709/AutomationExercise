package com.automationexercise.step.rest;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.EndPoint;
import com.automationexercise.action.StandardRestAction;
import com.automationexercise.api.UserAccount;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class CleanUpStep {

    @Given("Teardown is configured")
    public void dummyStepForScanner() {

    }

    @After("@delete-user")
    public void deleteCreatedUser() {
        UserAccount userAccount = Serenity.sessionVariableCalled(AutomationExerciseTestSuite.CREATED_USER);

        if (userAccount == null) {
            return;
        }

        SerenityRest.given()
                .contentType(ContentType.URLENC)
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.DELETE_ACCOUNT.apiPath())
                .formParam("email", userAccount.email())
                .formParam("password", userAccount.password())
                .delete()
                .then()
                .statusCode(200);
    }

}
