Feature: Placing Order

  Scenario: Placing an Order
            Given Open the application
            When Select the category
            And View the product
            And Choose the size
            And Choose the color
            Then Add the product to cart
            And verify the message
            And Verify the item added to cart
            And Enter the shipping details
            And Click Place an Order
            And Verify the confirmation message