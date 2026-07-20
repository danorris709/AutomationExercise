package com.automationexercise.step.rest;

import com.automationexercise.EndPoint;
import com.automationexercise.action.StandardRestAction;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class EndPointStep {

    private static final String API_PATH = "/productsList";

    @Steps
    private StandardRestAction standardRestAction;

    @When("I get the list of all {endpoint}")
    public void getAll(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendGet();
    }

    @When("I add a new {endpoint}")
    public void addNew(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendPost("{\"name\": \"Hello World\"}");
    }

    @When("I replace the {endpoint}")
    public void replace(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendPut("{\"name\": \"Hello World\"}");
    }

    @When("I delete the {endpoint}")
    public void delete(EndPoint endPoint) {
        this.standardRestAction
                .apiPath(endPoint.apiPath())
                .sendDelete();
    }
}
