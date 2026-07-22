package com.automationexercise.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class ScenarioAccountContext {

    public static final String DEFAULT_ALIAS = "default";

    private Map<String, AccountDraft> draftAccounts = new HashMap<>();
    private Map<String, UserAccount> registeredAccount = new HashMap<>();

    public ScenarioAccountContext() {}

    public AccountDraft createDraft() {
        return this.createDraft(DEFAULT_ALIAS);
    }

    public AccountDraft createDraft(String alias) {
        var draft = AccountDraft.validAccount(alias);
        this.registerDraft(alias, draft);
        return draft;
    }

    public void registerDraft(AccountDraft draft) {
        this.registerDraft(DEFAULT_ALIAS, draft);
    }

    public void registerDraft(String alias, AccountDraft draft) {
        this.draftAccounts.put(alias, draft);
    }

    public void updateDraft(UnaryOperator<AccountDraft> operator) {
        this.updateDraft(DEFAULT_ALIAS, operator);
    }

    public void updateDraft(String alias, UnaryOperator<AccountDraft> operator) {
        var draft = this.getDraft(alias);
        this.registerDraft(alias, operator.apply(draft));
    }

    public AccountDraft getDraft() {
        return this.getDraft(DEFAULT_ALIAS);
    }

    public AccountDraft getDraft(String alias) {
        return this.draftAccounts.get(alias);
    }

    public void registerAccount(UserAccount account) {
        this.registerAccount(DEFAULT_ALIAS, account);
    }

    public void registerAccount(String alias, UserAccount account) {
        this.registeredAccount.put(alias, account);
    }

    public UserAccount getAccount() {
        return this.getAccount(DEFAULT_ALIAS);
    }

    public UserAccount getAccount(String alias) {
        return this.registeredAccount.get(alias);
    }

    public void removeAccount() {
        this.removeAccount(DEFAULT_ALIAS);
    }

    public void removeAccount(String alias) {
        this.registeredAccount.remove(alias);
    }

    public List<UserAccount> getAccounts() {
        return List.copyOf(this.registeredAccount.values());
    }
}
