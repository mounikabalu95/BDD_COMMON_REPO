Feature: Test the functionality of domain ParaBank
 
  Scenario: Test the banking operations in customer Register
    Given I enter the url of bank domain
    When I enter customer details to pay
    Then I can able to pay the amount successfully