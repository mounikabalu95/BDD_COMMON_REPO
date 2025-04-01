Feature: Search a Book

  Scenario Outline: Find a Book
    Given I open the application
    When I search for the book by <value>
    Then I should see the book appear in the results


Examples:
    | value|
    | "l" |
    | "ile" |
    | "le" |
    | "Agile" |
    |"sjdhjsdh"|