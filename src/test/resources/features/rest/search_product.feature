Feature: Search Product API endpoint

   Scenario: Searching for products should return products
      When I search for products matching "top"
      Then I should get a successful response
      And I should get a list of products

   Scenario: Searching for products with no query param fails
         When I request a search for product
         Then I should get a response saying that it is a bad request
         And I should get a message matching "Bad request, search_product parameter is missing in POST request."

   Scenario: The search for products endpoint does not allow put requests
         When I replace the search for product
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The search for products endpoint does not allow delete requests
         When I delete the search for product
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."
