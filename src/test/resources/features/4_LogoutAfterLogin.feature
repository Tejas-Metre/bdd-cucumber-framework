Feature: Logout After Login

  Background:
    Given User opens the browser
    And navigates to "https://www.saucedemo.com"

  Scenario Outline: Logout functionality
    Given User logs in with "<username>" and "<password>"
    When User clicks on the menu
    And User clicks logout
    Then verify User should be redirected to the login page "Login"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |