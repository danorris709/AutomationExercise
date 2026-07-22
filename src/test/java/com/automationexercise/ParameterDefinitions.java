package com.automationexercise;

import io.cucumber.java.ParameterType;

public class ParameterDefinitions {

    @ParameterType("[^\"]+")
    public String message(String message) {
        return message;
    }

    @ParameterType("[^\"]+")
    public String alias(String alias) {
        return alias;
    }

    @ParameterType("[a-zA-Z ]+")
    public EndPoint endpoint(String endpoint) {
        return EndPoint.find(endpoint);
    }
}
