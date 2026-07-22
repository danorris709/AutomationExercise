package com.automationexercise.step.rest;

import com.automationexercise.EndPoint;
import com.automationexercise.action.rest.StandardRestAction;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Steps;

import java.util.Map;

public class EndPointStep {

    @Steps
    private StandardRestAction standardRestAction;

    @When("I get the list of all {endpoint}")
    public void getAll(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendGet();
    }

    @When("I get the {endpoint} with these details:")
    public void getAll(EndPoint endPoint, Map<String, String> details) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .params(details)
                .sendGet();
    }

    @When("I add/request a {endpoint}")
    public void addNew(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendPost();
    }

    @When("I add/request a {endpoint} with these details:")
    public void addNew(EndPoint endPoint, Map<String, String> details) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .params(details)
                .sendPost();
    }

    @When("I replace the {endpoint}")
    public void replace(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendPut();
    }

    @When("I replace the {endpoint} with these details:")
    public void replace(EndPoint endPoint, Map<String, String> details) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .modifier(spec -> {
                    spec.contentType(ContentType.URLENC);

                    for (var detail : details.entrySet()) {
                        spec.formParam(detail.getKey(), detail.getValue());
                    }
                })
                .sendPut();
    }

    @When("I delete the {endpoint}")
    public void delete(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendDelete();
    }

    @When("I search for products matching \"{message}\"")
    public void searchFor(String message) {
        this.standardRestAction
                .apiPath(EndPoint.SEARCH_FOR_PRODUCT.apiPath())
                .modifier(request -> request.param("search_product", message))
                .sendPost();
    }
}
