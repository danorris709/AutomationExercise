package com.automationexercise.step.rest;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.EndPoint;
import com.automationexercise.action.StandardRestAction;
import com.automationexercise.api.UserId;
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
        UserId userId = Serenity.sessionVariableCalled(AutomationExerciseTestSuite.CREATED_USER);

        if (userId == null) {
            return;
        }

        SerenityRest.given()
                .contentType(ContentType.URLENC)
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.DELETE_ACCOUNT.apiPath())
                .formParam("email", userId.email())
                .formParam("password", userId.password())
                .delete()
                .then()
                .statusCode(200);
    }

}
