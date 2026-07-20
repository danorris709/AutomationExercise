package com.automationexercise.step.rest;

import com.automationexercise.EndPoint;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;

import java.util.Locale;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class StandardRestStep {

    @Then("I should get a successful response")
    public void checkResponseIsSuccessful() {
        restAssuredThat(response -> response.body("responseCode", Matchers.equalTo(200)));
    }

    @Then("I should get a response saying that is unsupported")
    public void checkResponseIsUnsupported() {
        restAssuredThat(response -> response.body("responseCode", Matchers.equalTo(405)));
    }

    @Then("I should get a list of {endpoint}")
    public void checkResponseIsList(EndPoint endPoint) {
        restAssuredThat(response -> response
                .body(endPoint.name().toLowerCase(Locale.ROOT), Matchers.hasSize(Matchers.greaterThan(0))));
    }

    @Then("I should get a message matching \"{message}\"")
    public void checkResponseMessage(String message) {
        restAssuredThat(response -> response.body("message", Matchers.equalTo(message)));
    }

    @BeforeAll
    public static void setupParser() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }
}
