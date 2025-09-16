Feature: SauceDemo Login Functionality

  Background:
    Given User opens the browser
    And navigates to "https://www.saucedemo.com"

  Scenario Outline: Valid login with standard_user
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then User should be redirected to the Products page "Products"

    Examples:
      | username       | password     |
      | standard_user  | secret_sauce |

  Scenario Outline: Login with invalid password
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then user verify invalid credentials error message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username       | password    |
      | standard_user  | wrong_pass  |

  Scenario Outline: Login with locked out user
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then user verify locked out user error message "Epic sadface: Sorry, this user has been locked out."

    Examples:
      | username         | password     |
      | locked_out_user  | secret_sauce |

  Scenario Outline: Login with blank credentials
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then user verify blank username error message "Epic sadface: Username is required"

    Examples:
      | username | password |
      |          |          |

	  
	  