package com.automationexercise.action.rest;

import com.automationexercise.api.EndPoint;
import com.automationexercise.api.AccountDraft;
import com.automationexercise.api.UserAccount;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class AccountAction {

    @Step("Register account")
    public UserAccount registerAccount(AccountDraft accountDraft) {
        var request = SerenityRest.given()
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.CREATE_ACCOUNT.apiPath());

        for (var entry : accountDraft.properties().entrySet()) {
            request.param(entry.getKey(), entry.getValue());
        }

        request.post();
        return accountDraft.toAccount();
    }

    @Step("Update account details")
    public UserAccount updateAccount(UserAccount account, Map<String, String> newProperties) {
        var updatedAccount = account.update(newProperties);

        var parameters = updatedAccount.toParameters();

        var request = SerenityRest.given()
                .contentType(ContentType.URLENC)
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.UPDATE_ACCOUNT.apiPath());

        for (var entry : parameters.entrySet()) {
            request.formParam(entry.getKey(), entry.getValue());
        }

        request.put();

        return updatedAccount;
    }

    @Step("Delete account")
    public void deleteAccount(UserAccount account) {
        SerenityRest.given()
                .contentType(ContentType.URLENC)
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.DELETE_ACCOUNT.apiPath())
                .formParam("email", account.email())
                .formParam("password", account.password())
                .delete();
    }

    @Step("Verify account login")
    public void verifyLogin(UserAccount account) {
        SerenityRest.given()
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.VERIFY_LOGIN.apiPath())
                .formParam("email", account.email())
                .formParam("password", account.password())
                .post();
    }

    @Step("Verify account login with a missing property")
    public void verifyLoginWithout(UserAccount account, String property) {
        var request = SerenityRest.given()
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.VERIFY_LOGIN.apiPath());

        if (!property.equals("email")) {
            request.formParam("email", account.email());
        }

        if (!property.equals("password")) {
            request.formParam("password", account.password());
        }

        request.post();
    }

    @Step("Get Account Details")
    public void getDetails(UserAccount account) {
        SerenityRest.given()
                .baseUri(StandardRestAction.API_URL + "/" + EndPoint.USER_ACCOUNT_DETAIL.apiPath())
                .param("email", account.email())
                .get();
    }

}
