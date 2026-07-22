Feature: User Account Details API endpoint

   Scenario: Checking my user account details
        Given I have a registered account
        When I get my account details
        Then I should get a successful response