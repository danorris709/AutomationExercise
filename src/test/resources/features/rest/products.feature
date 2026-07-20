Feature: Products API endpoint

   Scenario: The products list endpoint gives a list of products
         When I get the list of all products
         Then I should get a successful response
         And I should get a list of products

   Scenario: The products list endpoint does not allow post requests
         When I add a new product
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The products list endpoint does not allow put requests
         When I replace the products
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The products list endpoint does not allow delete requests
         When I delete the products
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."
