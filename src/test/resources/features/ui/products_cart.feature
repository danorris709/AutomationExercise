Feature: Products Cart tests

  Background:
    Given I am on the home page

  Scenario:
  Scenario: Add multiple products to the shopping cart
    When I navigate to the products page
    And I add the following products to my cart:
      | 1st |
      | 2nd |
    And I navigate to the cart page

    Then I should see 2 products in my cart
    And the total price should match the individual price