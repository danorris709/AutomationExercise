Feature: Verify Login End Point

   Scenario: Testing POST for verify login endpoint
        Given I have a registered account
        When I verify my account login
        Then I should get a successful response
        And I should get a message matching "User exists!"

   Scenario: Testing POST for verify login endpoint while excluding specific parameters
        Given I have a registered account
        When I verify my account login without the ""<property>""
        Then I should get a response saying that it is a bad request
        And I should get a message matching "Bad request, email or password parameter is missing in POST request."

        Examples:
          | property |
          | email    |
          | password |

   Scenario: Testing POST for verify login endpoint with incorrect details
        Given I have a registered account
        When I verify my account login but override:
          | password      | InvalidPassword123                 |
        Then I should get a response saying that it is not found
        And I should get a message matching "User not found!"

   Scenario: The verify login endpoint does not allow delete requests
         When I delete the verification
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The verify login endpoint does not allow put requests
         When I replace the verification
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The verify login endpoint does not allow get requests
         When I get the list of all verification
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."