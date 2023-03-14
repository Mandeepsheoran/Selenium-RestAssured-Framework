Feature: Update User Details

  Scenario: Update existing user
    Given Request is given with data
    When First name is replaced
    And API endpoint is up and running
    Then User should be updated with new details
    
    
  Scenario: Validate update user response
    Given Request is given with data
    When First name is replaced
    And API endpoint is up and running
    Then Verify if email is present in response

  Scenario: Validation last name
    Given Request is given with data
    When Last name is replaced from request
    And API endpoint is up and running
    Then Check if last name is replaced in response
    
  Scenario: Response body validation
    Given Request is given with data
    When Response body is posted
    And API endpoint is up and running
    Then Verify that response body is available for testing
    