defaultTasks("clean", "test", "aggregate")

plugins {
    java
    eclipse
    id("idea")
    id("net.serenity-bdd.serenity-gradle-plugin") version "5.3.2"
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(libs.serenity.core)
    testImplementation(libs.serenity.cucumber)
    testImplementation(libs.serenity.screenplay)
    testImplementation(libs.serenity.screenplay.webdriver)
    testImplementation(libs.serenity.ensure)
    testImplementation(libs.serenity.rest.assured)
    testImplementation(libs.junit.launcher)
    testImplementation(libs.cucumber.engine)
    testImplementation(libs.junit.suite)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.vintage)
    implementation(libs.logback.classic)
    testImplementation(libs.assertj.core)
}


tasks.test {
    useJUnitPlatform()
    finalizedBy("aggregate", "reports")
}

serenity {
    reports = listOf("single-page-html")
}

gradle.startParameter.isContinueOnFailure = true
