package com.automationexercise.action;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class StandardRestAction {

    public static final String API_URL = "https://automationexercise.com/api";

    private ThreadLocal<String> apiPath = new ThreadLocal<>();

    public StandardRestAction apiPath(String path) {
        this.apiPath.set(path);
        return this;
    }

    @Step("Sends a get to the api path")
    public void sendGet() {
        try {
            SerenityRest.given()
                    .get(API_URL + this.apiPath.get());
        } finally {
            this.apiPath.remove();
        }
    }

    @Step("Sends a post request to the current api path")
    public void sendPost(Object body) {
        try {
            SerenityRest.given()
                    .baseUri(API_URL + this.apiPath.get())
                    .body(body)
                    .post();
        } finally {
            this.apiPath.remove();
        }
    }

    @Step("Sends a put request to the current api path")
    public void sendPut(Object body) {
        try {
            SerenityRest.given()
                    .baseUri(API_URL + this.apiPath.get())
                    .body(body)
                    .put();
        } finally {
            this.apiPath.remove();
        }
    }

    @Step("Sends a delete request to the current api path")
    public void sendDelete() {
        try {
            SerenityRest.given()
                    .baseUri(API_URL + this.apiPath.get())
                    .delete();
        } finally {
            this.apiPath.remove();
        }
    }


}
