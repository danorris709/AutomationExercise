Feature: Create Account API endpoint

   Scenario: Deleting an account with all parameters
        Given I have a registered account
        When I delete my account
        Then I should get a successful response
        And I should get a message matching "Account deleted!"