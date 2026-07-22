Feature: Update Account API endpoint

   Scenario: Updating an account with all parameters
        Given I have a registered account
        When I update my account with properties:
          | title         | Mrs               |
          | firstname     | Jane             |
          | lastname      | Doe              |
          | name          | Jane Doe         |
        Then I should get a successful response
        And I should get a message matching "User updated!"