package com.automationexercise;

import com.automationexercise.api.ScenarioAccountContext;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.core.Serenity;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

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

    public static ScenarioAccountContext getAccountContext() {
        ScenarioAccountContext context = Serenity.sessionVariableCalled(ACCOUNT_CONTEXT);

        if (context == null) {
            context = new ScenarioAccountContext();
            Serenity.setSessionVariable(ACCOUNT_CONTEXT).to(context);
        }

        return context;
    }
}
