@timesheets
Feature: This feature is to get the pending time sheet

  Scenario Outline: This test is to verify the pending timesheet
    Given The user is on the homepage
    And the user clicks on the time option from the menu
    And the user enter the name as "John Smith"
    And clicks on the view button
    Then the user should see the message as  "<message>"

    Examples: 
      | message             |
      | No Timesheets Found |