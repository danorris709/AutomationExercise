package com.automationexercise.api;

import java.util.HashMap;
import java.util.Map;

public record UserAccount(String email, String password, Map<String, String> properties) {

    public UserAccount(String email, String password, Map<String, String> properties) {
        this.email = email;
        this.password = password;
        this.properties = cleanMap(properties);
    }

    public UserAccount(Map<String, String> properties) {
        this(properties.get("email"), properties.get("password"), properties);
    }

    public String name() {
        return this.properties.get("name");
    }

    private static Map<String, String> cleanMap(Map<String, String> properties) {
        Map<String, String> copy = new HashMap<>(properties);
        copy.remove("email");
        copy.remove("password");
        return Map.copyOf(copy);
    }

    public UserAccount update(Map<String, String> properties) {
        var copy = new HashMap<>(this.properties);
        copy.putAll(properties);
        return new UserAccount(this.email, this.password, copy);
    }

    public Map<String, String> toParameters() {
        var copy = new HashMap<>(this.properties);
        copy.put("email", this.email);
        copy.put("password", this.password);
        return copy;
    }

    public UserAccount override(Map<String, String> properties) {
        var email = properties.getOrDefault("email", this.email);
        var password = properties.getOrDefault("password", this.password);
        var account = new UserAccount(email, password, this.properties);
        return account.update(properties);
    }

}
