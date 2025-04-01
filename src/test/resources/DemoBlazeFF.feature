Feature: Test the functionality of DemoBlaze


Background:
    Given I navigate to the login page

  Scenario Outline: Login with valid credentials
    When I enter username "<Username>" and password "<Password>"
    And I click the login button
    Then I can able to login

    Examples:
      | Username   | Password   | 
      | muthu123   | muthu123   | 
      | muthu456   | muthu456   |
      
    