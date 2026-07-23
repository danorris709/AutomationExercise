Feature: Testing pages

  Background:
    Given I am on the home page

  Scenario: Clicking the test cases button
     When I navigate to the test cases page
     Then I should see the list of test cases

  Scenario: Clicking the API testing button
     When I navigate to the api test cases page
     Then I should see the list of api test cases