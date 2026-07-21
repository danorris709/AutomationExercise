Feature: User Account Details API endpoint

   @delete-user
   Scenario: Registering an account with all parameters
        When I create an account with the details:
          | title         | Mr               |
          | firstname     | John             |
          | lastname      | Doe              |
          | name          | John Doe         |
          | email         | john.doe.register.1@qa.com  |
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
        And I get the account detail with these details:
          | email         | john.doe.register.1@qa.com  |
        Then I should get a successful response