
Feature: Complete Checkout with Multiple Data Sets

  Background:
    Given User opens the browser
    And navigates to "https://www.saucedemo.com"

  Scenario Outline: Complete checkout with valid data
   	Given User logs in with "<username>" and "<password>"
    When User adds "<product>" to the cart
    And User click on cart option to proceeds to checkout
    And User click on checkout button
    And verify Checkout Your Information page is displayed "Checkout: Your Information"
    And User enters checkout information "<firstName>", "<lastName>", "<zipCode>"
    And User click on continues button
    And User click on finish the order button
   	Then Order confirmation page should be displayed "Thank you for your order!"
    And User click on Back Home button

    Examples:
      | username      | password     | product              | firstName | lastName | zipCode |
      | standard_user | secret_sauce |Sauce Labs Backpack   | John      | Doe      | 12345   |