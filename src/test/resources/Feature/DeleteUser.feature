Feature: Delete User Details

  Scenario: Delete existing user
    Given Request is given with data
    When API endpoint is up and running
    Then User should be deleted from database
    
    
  Scenario: Status check after deletion
     Given Request is given with data
    When API endpoint is up and running
    Then Status code should be 204 after deletion

    