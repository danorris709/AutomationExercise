Feature: Create Account API endpoint

   Scenario: Registering an account with all parameters
        Given I create a valid account
        When I register my account
        Then I should get a successfully created response
        And I should get a message matching "User created!"