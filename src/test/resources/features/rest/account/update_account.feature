Feature: Update Account API endpoint

   @delete-user
   Scenario: Updating an account with all parameters
        When I create an account with the details:
          | title         | Mr               |
          | firstname     | John             |
          | lastname      | Doe              |
          | name          | John Doe         |
          | email         | john.doe.update.1@qa.com  |
          | password      | SecurePass123!   |
          | birth_date    | 15               |
          | birth_month   | 08               |
          | birth_year    | 1990             |
          | company       | QA Testing Corp  |
          | address1      | 123 Main Street  |
          | address2      | Suite 400        |
          | country       | United States    |
          | state         | California       |
          | city          | Los Angeles      |
          | zipcode       | 90001            |
          | mobile_number | 555-0199         |
        And I replace the update with these details:
          | title         | Mrs               |
          | firstname     | Jane             |
          | lastname      | Doe              |
          | name          | Jane Doe         |
          | email         | john.doe.update.1@qa.com  |
          | password      | SecurePass123!   |
          | birth_date    | 15               |
          | birth_month   | 08               |
          | birth_year    | 1990             |
          | company       | QA Testing Corp  |
          | address1      | 123 Main Street  |
          | address2      | Suite 400        |
          | country       | United States    |
          | state         | California       |
          | city          | Los Angeles      |
          | zipcode       | 90001            |
          | mobile_number | 555-0199         |
        Then I should get a successful response
        And I should get a message matching "User updated!"