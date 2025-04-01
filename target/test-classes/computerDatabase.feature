Feature: Computer Database Management
@searchComputer
  Scenario: Search for a computer in the database
    Given the user opens the computer database application
    When the list of computers is displayed
    And the user searches for a computer by name
    Then the search results should display the correct computer
