package com.automationexercise;

import com.automationexercise.api.RequestContext;
import com.automationexercise.api.ScenarioAccountContext;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.core.Serenity;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.function.UnaryOperator;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.automationexercise"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline"
)
public class AutomationExerciseTestSuite {

    public static final String ACCOUNT_CONTEXT = "accountContext";
    public static final String REQUEST_CONTEXT = "requestContext";
    public static final String LOGGED_IN = "loggedIn";

    public static ScenarioAccountContext getAccountContext() {
        return (ScenarioAccountContext) Serenity.getCurrentSession().computeIfAbsent(ACCOUNT_CONTEXT, _ -> new ScenarioAccountContext());
    }

    public static boolean isLoggedIn() {
        return (boolean) Serenity.getCurrentSession().getOrDefault(LOGGED_IN, false);
    }

    public static void setLoggedIn(boolean loggedIn) {
        Serenity.getCurrentSession().put(LOGGED_IN, loggedIn);
    }
}
