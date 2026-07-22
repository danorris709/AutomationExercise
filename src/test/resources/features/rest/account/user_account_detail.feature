Feature: User Account Details API endpoint

   Scenario: Registering an account with all parameters
        Given I have a registered account
        When I get my account details
        Then I should get a successful response