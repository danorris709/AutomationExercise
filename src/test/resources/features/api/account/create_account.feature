Feature: Create Account API endpoint

   Scenario: Registering a valid account with all details supplied
        Given I create a valid account
        When I register my account
        Then I should get a successfully created response
        And I should get a message matching "User created!"

   Scenario: Registering a valid account excluding some required details
        Given I create a valid account
        When I do not have ""<property>"" set
        And I register my account
        Then I should get a response saying that it is a bad request
        And I should get a message matching "Bad request, <property> parameter is missing in POST request."

        Examples:
          | property |
          | email    |
          | password |
          | name     |
          | firstname |
          | lastname  |
          | address1 |
          | country |
          | zipcode |
          | state |
          | city |
          | mobile_number |

   Scenario: Registering a valid account excluding some optional details
        Given I create a valid account
        When I do not have ""<property>"" set
        And I register my account
        Then I should get a successfully created response
        And I should get a message matching "User created!"

        Examples:
          | title    |
          | birth_date |
          | birth_month |
          | birth_year |
          | company |
          | address2 |