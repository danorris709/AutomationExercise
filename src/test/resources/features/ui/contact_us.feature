Feature: Contact Us Form

  Background:
    Given I am on the home page

  Scenario: Entering valid details into contact us form
    When I navigate to the contact us page
    Then I should see the get in touch form

    When I fill in the contact details with "Test Name" and "test.email@gmail.com"
    And I fill in the subject with "Hello this is a test submission"
    And I fill in the message with "Hello this is a test submission"
    And I upload a test file "test_file.txt"
    And I click to submit
    And I click the OK button
    Then I should see the success message

    When I click the home button
    Then I should see the home page

  Scenario: Entering valid details into contact us form with no file
    When I navigate to the contact us page
    Then I should see the get in touch form

    When I fill in the contact details with "Test Name" and "test.email@gmail.com"
    And I fill in the subject with "Hello this is a test submission"
    And I fill in the message with "Hello this is a test submission"
    And I click to submit
    And I click the OK button
    Then I should see the success message

    When I click the home button
    Then I should see the home page

  Scenario: Entering valid details into contact us form with no file or message
    When I navigate to the contact us page
    Then I should see the get in touch form

    When I fill in the contact details with "Test Name" and "test.email@gmail.com"
    And I fill in the subject with "Hello this is a test submission"
    And I click to submit
    And I click the OK button
    Then I should see the success message

    When I click the home button
    Then I should see the home page

