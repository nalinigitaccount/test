@GetCEOName
Feature: This feature is to get the CEO name of Orange hrm

  Scenario Outline: This test is to verify the CEO Name
    Given The user is logged in and is on Home Page
    When User clicks on the Directory options from the menu bar
    And the user selects the job title as "Chief Executive Officer" from the drop down
    And click on the search button
    Then user should see the CEO name as "<CEO_Name>"

    Examples: 
      | CEO_Name   |
      | John Smith |
     
