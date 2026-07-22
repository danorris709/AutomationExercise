package com.automationexercise.action.rest;

import com.automationexercise.api.RequestContext;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;
import java.util.function.Consumer;

public class StandardRestAction {

    public static final String API_URL = "https://automationexercise.com/api";

    private ThreadLocal<RequestContext> requestContext = new ThreadLocal<>();

    public StandardRestAction apiPath(String path) {
        this.requestContext.set(this.getContext().apiPath(path));
        return this;
    }

    public StandardRestAction body(Object body) {
        return this.modifier(requestSpecification -> requestSpecification.body(body));
    }

    public StandardRestAction params(Map<String, String> params) {
        return this.modifier(request -> {
            for (var param : params.entrySet()) {
                request.param(param.getKey(), param.getValue());
            }
        });
    }

    public StandardRestAction modifier(Consumer<RequestSpecification> modifier) {
        this.requestContext.set(this.getContext().modifier(modifier));
        return this;
    }

    private RequestContext getContext() {
        var context = this.requestContext.get();

        if (context == null) {
            context = RequestContext.empty(API_URL);
        }

        return context;
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
        try {
            var request = SerenityRest.given();

            this.applyContext(request);

            finalMethod.accept(request);
        } finally {
            this.requestContext.remove();
        }
    }

    private void applyContext(RequestSpecification requestSpecification) {
        var modifiers = this.requestContext.get().modifiers();

        for (var modifier : modifiers) {
            modifier.accept(requestSpecification);
        }
    }
}
