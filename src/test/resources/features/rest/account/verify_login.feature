Feature: Verify Login End Point

   @delete-user
   Scenario: Testing POST for verify login endpoint
        When I create an account with the details:
          | title         | Mr                        |
          | firstname     | John                      |
          | lastname      | Doe                       |
          | name          | John Doe                  |
          | email         | john.doe.verify.1@qa.com  |
          | password      | SecurePass123!            |
          | birth_date    | 15                        |
          | birth_month   | 08                        |
          | birth_year    | 1990                      |
          | company       | QA Testing Corp           |
          | address1      | 123 Main Street           |
          | address2      | Suite 400                 |
          | country       | United States             |
          | state         | California                |
          | city          | Los Angeles               |
          | zipcode       | 90001                     |
          | mobile_number | 555-0199                  |
        And I request a verification with these details:
          | email         | john.doe.verify.1@qa.com  |
          | password      | SecurePass123!            |
        Then I should get a successful response
        And I should get a message matching "User exists!"

   @delete-user
   Scenario: Testing POST for verify login endpoint with only the password parameter
        When I create an account with the details:
          | title         | Mr                        |
          | firstname     | John                      |
          | lastname      | Doe                       |
          | name          | John Doe                  |
          | email         | john.doe.verify.2@qa.com  |
          | password      | SecurePass123!            |
          | birth_date    | 15                        |
          | birth_month   | 08                        |
          | birth_year    | 1990                      |
          | company       | QA Testing Corp           |
          | address1      | 123 Main Street           |
          | address2      | Suite 400                 |
          | country       | United States             |
          | state         | California                |
          | city          | Los Angeles               |
          | zipcode       | 90001                     |
          | mobile_number | 555-0199                  |
        And I request a verification with these details:
          | password      | SecurePass123!            |
        Then I should get a response saying that it is a bad request
        And I should get a message matching "Bad request, email or password parameter is missing in POST request."

   @delete-user
   Scenario: Testing POST for verify login endpoint with only the email parameter
        When I create an account with the details:
          | title         | Mr                        |
          | firstname     | John                      |
          | lastname      | Doe                       |
          | name          | John Doe                  |
          | email         | john.doe.verify.3@qa.com  |
          | password      | SecurePass123!            |
          | birth_date    | 15                        |
          | birth_month   | 08                        |
          | birth_year    | 1990                      |
          | company       | QA Testing Corp           |
          | address1      | 123 Main Street           |
          | address2      | Suite 400                 |
          | country       | United States             |
          | state         | California                |
          | city          | Los Angeles               |
          | zipcode       | 90001                     |
          | mobile_number | 555-0199                  |
        And I request a verification with these details:
          | email         | john.doe.verify.3@qa.com  |
        Then I should get a response saying that it is a bad request
        And I should get a message matching "Bad request, email or password parameter is missing in POST request."

   @delete-user
   Scenario: Testing POST for verify login endpoint with incorrect details
        When I create an account with the details:
          | title         | Mr                        |
          | firstname     | John                      |
          | lastname      | Doe                       |
          | name          | John Doe                  |
          | email         | john.doe.verify.4@qa.com  |
          | password      | SecurePass123!            |
          | birth_date    | 15                        |
          | birth_month   | 08                        |
          | birth_year    | 1990                      |
          | company       | QA Testing Corp           |
          | address1      | 123 Main Street           |
          | address2      | Suite 400                 |
          | country       | United States             |
          | state         | California                |
          | city          | Los Angeles               |
          | zipcode       | 90001                     |
          | mobile_number | 555-0199                  |
        And I request a verification with these details:
          | email         | john.doe.verify.4@qa.com  |
          | password      | SecurePass                 |
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