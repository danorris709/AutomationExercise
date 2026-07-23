package com.automationexercise.action.rest;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.api.RequestContext;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class StandardRestAction {

    public static final String API_URL = "https://automationexercise.com/api";

    public StandardRestAction apiPath(String path) {
        this.modifyContext(context -> context.apiPath(path));
        return this;
    }

    public StandardRestAction params(Map<String, String> params) {
        return this.modifier(request -> {
            for (var param : params.entrySet()) {
                request.param(param.getKey(), param.getValue());
            }
        });
    }

    public StandardRestAction modifier(Consumer<RequestSpecification> modifier) {
        this.modifyContext(context -> context.modifier(modifier));
        return this;
    }

    private RequestContext getContext() {
        return (RequestContext) Serenity.getCurrentSession().computeIfAbsent(AutomationExerciseTestSuite.REQUEST_CONTEXT, ___ -> RequestContext.empty(API_URL));
    }

    private void modifyContext(UnaryOperator<RequestContext> modifier) {
        var context = this.getContext();
        var updatedContext = modifier.apply(context);
        Serenity.getCurrentSession().put(AutomationExerciseTestSuite.REQUEST_CONTEXT, updatedContext);
    }

    @Step("Sends a get to the api path")
    public void sendGet() {
        this.sendRequest(RequestSpecification::get);
    }

    @Step("Sends a post request to the current api path")
    public void sendPost() {
        this.sendRequest(RequestSpecification::post);
    }

    @Step("Sends a put request to the current api path")
    public void sendPut() {
        this.sendRequest(RequestSpecification::put);
    }

    @Step("Sends a delete request to the current api path")
    public void sendDelete() {
        this.sendRequest(RequestSpecification::delete);
    }

    private void sendRequest(Consumer<RequestSpecification> finalMethod) {
        var request = SerenityRest.given();

        this.applyContext(request);

        finalMethod.accept(request);
    }

    private void applyContext(RequestSpecification requestSpecification) {
        var modifiers = this.getContext().modifiers();

        for (var modifier : modifiers) {
            modifier.accept(requestSpecification);
        }
    }
}
