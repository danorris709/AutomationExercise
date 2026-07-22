package com.automationexercise.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record AccountDraft(Map<String, String> properties) {

    public AccountDraft(Map<String, String> properties) {
        this.properties = Map.copyOf(properties);
    }

    public AccountDraft with(String key, String value) {
        var copy = new HashMap<>(this.properties);
        copy.put(key, value);
        return new AccountDraft(copy);
    }

    public AccountDraft without(String key) {
        var copy = new HashMap<>(this.properties);
        copy.remove(key);
        return new AccountDraft(copy);
    }

    public UserAccount toAccount() {
        return new UserAccount(this.properties);
    }

    public static AccountDraft validAccount() {
        return validAccount("default");
    }

    public String name() {
        return this.properties.get("name");
    }

    public String email() {
        return this.properties.get("email");
    }

    public static AccountDraft validAccount(String alias) {
        Map<String, String> properties = new HashMap<>();

        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        String uniqueEmail = alias + uniqueId + "@qa.com";

        properties.put("title", "Mr");
        properties.put("firstname", "John");
        properties.put("lastname", "Doe");
        properties.put("name", "John Doe");
        properties.put("email", uniqueEmail);
        properties.put("password", "SecurePass123!");
        properties.put("birth_date", "15");
        properties.put("birth_month", "August");
        properties.put("birth_year", "1990");
        properties.put("company", "QA Testing Corp");
        properties.put("address1", "123 Main Street");
        properties.put("address2", "Suite 400");
        properties.put("country", "United States");
        properties.put("state", "California");
        properties.put("city", "Los Angeles");
        properties.put("zipcode", "90001");
        properties.put("mobile_number", "555-0199");

        return new AccountDraft(properties);
    }
}
