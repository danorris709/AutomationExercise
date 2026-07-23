Feature: Products Cart tests

  Background:
    Given I am on the home page

  Scenario: Add multiple products to the shopping cart
    When I navigate to the products page
    And I add the following products to my cart:
      | 1st |
      | 2nd |
    And I navigate to the cart page

    Then I should see 2 products in my cart
    And the total price should match the individual price

  Scenario: Verify shipping address is equal to account address
    Given I have a registered account
    When I navigate to the Signup and Login page
    And I login with my email and password

    Then I should see the home page
    And I should be logged in

    When I navigate to the products page
    And I add the following products to my cart:
      | 1st |
      | 2nd |
    And I navigate to the cart page
    And I proceed to checkout
    Then the delivery address should be correct
    And the billing address should be correct