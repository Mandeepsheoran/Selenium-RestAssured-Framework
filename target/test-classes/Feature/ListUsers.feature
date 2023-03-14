Feature: List users

  Scenario: API to get list of users
    Given API endpoint
    When User id is provided
    Then Response should give complete user details
    
    
   Scenario: Check content type from response
    Given API endpoint
    When User id is provided
    Then Content type should be application json

   Scenario: Check response user details
    Given API endpoint
    When User id is provided
    Then Content should have first name field
    