Feature: Post User Details

  Scenario: Create a new user
    Given Request is given with data
    When Data is retrived from json file
    And API endpoint is up and running
    Then User should be able to create new user
    
    
  Scenario: New user registration
    Given Request is given with data
    When Data is retrived from json file
    And API endpoint is up and running
    Then New user is registered successfully

  Scenario: Validation for missing field in request
    Given Request is given with data
    When Data is retrived from json file
    And API endpoint is up and running
    Then Response should have validation message for missing field
    