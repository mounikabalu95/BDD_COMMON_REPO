Feature: Test the functionality of DemoBlaze

Scenario: Choosing and adding the item into the cart
    Given Should be logged in into the system
    When I select the item from list
    And I have to add to the cart
    And I have to pay the amount for the item
    Then I can able to buy the product