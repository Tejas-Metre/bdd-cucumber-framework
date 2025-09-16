Feature: Add Product to Cart and Verify

  Background:
    Given User opens the browser
    And navigates to "https://www.saucedemo.com"

  Scenario Outline: Add product to cart and verify
    Given User logs in with "<username>" and "<password>"
    When User adds "<product>" to the cart
    Then Cart icon should show "<count>" item(s)

    Examples:
      | username      | password     | product               | count |
      | standard_user | secret_sauce | Sauce Labs Backpack   | 1     |
      
      
      