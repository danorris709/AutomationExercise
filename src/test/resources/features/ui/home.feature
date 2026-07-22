Feature: User Registration Management

  Background:
    Given I am on the home page

  Scenario: Register a new user and delete the account
    When I navigate to the Signup and Login page
    Then I should see the "New User Signup!" form

    When I create a valid account
    And I start the signup process
    Then I should be prompted to "ENTER ACCOUNT INFORMATION"

    When I complete the registration details
    And I signup for the newsletter
    And I signup for the special offers
    And I click the create account button
    Then I should see the "ACCOUNT CREATED!" success screen

    When I proceed from the account created screen
    Then I should be logged in

    When I click to delete my account
    Then I should see the "ACCOUNT DELETED!" success screen
    And I proceed from the account deleted screen
