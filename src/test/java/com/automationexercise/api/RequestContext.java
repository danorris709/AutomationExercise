package com.automationexercise.api;

import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record RequestContext(String baseUrl, List<Consumer<RequestSpecification>> modifiers) {

    public RequestContext(String baseUrl, List<Consumer<RequestSpecification>> modifiers) {
        this.baseUrl = baseUrl;
        this.modifiers = List.copyOf(modifiers);
    }

    public static RequestContext empty(String baseUrl) {
        return new RequestContext(baseUrl, List.of());
    }

    public RequestContext apiPath(String path) {
        return this.modifier(request -> request.baseUri(this.baseUrl + "/" + path));
    }

    public RequestContext modifier(Consumer<RequestSpecification> modifier) {
        var modifiers = new ArrayList<>(this.modifiers);
        modifiers.add(modifier);
        return new RequestContext(this.baseUrl, modifiers);
    }
}
