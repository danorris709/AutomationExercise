Feature: Brands API endpoint

   Scenario: The brands list endpoint gives a list of brands
         When I get the list of all brands
         Then I should get a successful response
         And I should get a list of brands

   Scenario: The brands list endpoint does not allow post requests
         When I add a new brand
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The brands list endpoint does not allow put requests
         When I replace the brands
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."

   Scenario: The brands list endpoint does not allow delete requests
         When I delete the brands
         Then I should get a response saying that is unsupported
         And I should get a message matching "This request method is not supported."
