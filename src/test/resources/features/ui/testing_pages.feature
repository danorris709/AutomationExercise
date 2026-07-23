Feature: Testing pages

  Background:
    Given I am on the home page

  Scenario: Clicking the test cases button
     When I navigate to the test cases page
     Then I should see the list of test cases

  Scenario: Clicking the API testing button
     When I navigate to the api test cases page
     Then I should see the list of api test cases

  Scenario: Clicking the test cases button when logged in
     Given I have a registered account

     When I navigate to the Signup and Login page
     And I login with my email and password

     Then I should see the home page
     And I should be logged in

     When I navigate to the test cases page
     Then I should see the list of test cases

  Scenario: Clicking the API testing button when logged in
     Given I have a registered account

     When I navigate to the Signup and Login page
     And I login with my email and password

     Then I should see the home page
     And I should be logged in

     When I navigate to the api test cases page
     Then I should see the list of api test cases