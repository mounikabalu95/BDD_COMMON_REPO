Feature: Add a book to the cart

  Scenario: User adds a book to the cart and verifies it
            Given User is on the homepage
            When User clicks on the category
            And User selects a book from the list
            And User clicks on the cart button
            Then The book should be added to the cart
            And The cart should display the selected book