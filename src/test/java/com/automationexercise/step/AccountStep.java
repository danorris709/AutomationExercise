package com.automationexercise.step;

import com.automationexercise.AutomationExerciseTestSuite;
import com.automationexercise.action.rest.AccountAction;
import com.automationexercise.api.ScenarioAccountContext;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.Map;

public class AccountStep {

    @Steps
    private AccountAction accountAction;

    @Given("I create a valid account")
    public void createAccount() {
        this.accountContext().createDraft();
    }

    @Given("I create a valid account with alias \"{alias}\"")
    public void createAccount(String alias) {
        this.accountContext().createDraft(alias);
    }

    @Given("I have an unregistered account")
    public void setupUnregisteredAccount() {
        var account = this.accountContext().createDraft().toAccount();
        this.accountContext().registerAccount(account);
    }

    @Given("I have a registered account")
    public void setupRegisteredAccount() {
        var draft = this.accountContext().createDraft();
        var account = this.accountAction.registerAccount(draft);
        this.accountContext().registerAccount(account);
    }

    @Given("I have a registered account called \"{alias}\"")
    public void setupRegisteredAccount(String alias) {
        var draft = this.accountContext().createDraft(alias);
        var account = this.accountAction.registerAccount(draft);
        this.accountContext().registerAccount(alias, account);
    }

    @When("I do not have \"{string}\" set")
    public void unsetProperty(String key) {
        this.accountContext().updateDraft(draft -> draft.without(key));
    }

    @When("I do not have \"{string}\" set on \"{alias}\"")
    public void unsetProperty(String property, String alias) {
        this.accountContext().updateDraft(alias, draft -> draft.without(property));
    }

    @When("I register my account")
    public void registerAccount() {
        this.accountAction.registerAccount(this.accountContext().getDraft());
    }

    @When("I register my account called \"{alias}\"")
    public void registerAccount(String alias) {
        this.accountAction.registerAccount(this.accountContext().getDraft(alias));
    }

    @When("I update my account with properties:")
    public void updateAccount(Map<String, String> update) {
        this.accountAction.updateAccount(this.accountContext().getAccount(), update);
    }

    @When("I update my account called \"{alias}\" with properties:")
    public void updateAccount(String alias, Map<String, String> update) {
        this.accountAction.updateAccount(this.accountContext().getAccount(alias), update);
    }

    @When("I delete my account")
    public void deleteAccount() {
        this.accountAction.deleteAccount(this.accountContext().getAccount());
        this.accountContext().removeAccount();
    }

    @When("I delete my account called \"{alias}\"")
    public void deleteAccount(String alias) {
        this.accountAction.deleteAccount(this.accountContext().getAccount(alias));
        this.accountContext().removeAccount(alias);
    }

    @When("I verify my account login")
    public void verifyLogin() {
        this.accountAction.verifyLogin(this.accountContext().getAccount());
    }

    @When("I verify my account login for my account called \"{alias}\"")
    public void verifyLogin(String alias) {
        this.accountAction.verifyLogin(this.accountContext().getAccount(alias));
    }

    @When("I verify my account login without the \"{string}\"")
    public void verifyLoginWithout(String property) {
        this.accountAction.verifyLoginWithout(this.accountContext().getAccount(), property);
    }

    @When("I verify my account login for my account called \"{alias}\" without the \"{string}\"")
    public void verifyLoginWithout(String alias, String property) {
        this.accountAction.verifyLoginWithout(this.accountContext().getAccount(alias), property);
    }

    @When("I verify my account login but override:")
    public void verifyLoginOverride(Map<String, String> overrides) {
        var account = this.accountContext().getAccount();

        this.accountAction.verifyLogin(account.override(overrides));
    }

    @When("I verify my account login for my account called \"{alias}\" but override:")
    public void verifyLogin(String alias, Map<String, String> overrides) {
        var account = this.accountContext().getAccount(alias);

        this.accountAction.verifyLogin(account.override(overrides));
    }

    @When("I get my account details")
    public void getAccountDetails() {
        this.accountAction.getDetails(this.accountContext().getAccount());
    }

    @When("I get my account details for my account called \"{alias}\"")
    public void getAccountDetails(String alias) {
        this.accountAction.getDetails(this.accountContext().getAccount(alias));
    }

    @After
    public void deleteCreatedUser() {
        for (var account : this.accountContext().getAccounts()) {
            this.accountAction.deleteAccount(account);
        }
    }
    
    private ScenarioAccountContext accountContext() {
        return AutomationExerciseTestSuite.getAccountContext();
    }
}
