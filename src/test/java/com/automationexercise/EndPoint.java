package com.automationexercise;

import com.google.common.graph.EndpointPair;

import java.util.Locale;
import java.util.Set;

public enum EndPoint {

    PRODUCTS("productsList", "product"),
    BRANDS("brandsList", "brand"),
    SEARCH_FOR_PRODUCT("searchProduct", "search for product"),
    CREATE_ACCOUNT("createAccount", "create account"),
    DELETE_ACCOUNT("deleteAccount", "delete account"),
    VERIFY_LOGIN("verifyLogin", "verification", "verify login"),
    UPDATE_ACCOUNT("updateAccount", "update account", "update"),
    USER_ACCOUNT_DETAIL("getUserDetailByEmail", "user account detail", "account detail"),

    ;

    private final String apiPath;
    private final Set<String> alias;

    EndPoint(String apiPath, String... alias) {
        this.apiPath = apiPath;
        this.alias = Set.of(alias);
    }

    public String apiPath() {
        return this.apiPath;
    }

    public static EndPoint find(String name) {
        for (var endPoint : values()) {
            if (endPoint.name().equalsIgnoreCase(name)) {
                return endPoint;
            }

            if (endPoint.alias.contains(name.toLowerCase(Locale.ROOT))) {
                return endPoint;
            }
        }

        return null;
    }
}
