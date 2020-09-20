Feature: Login Feature

  Scenario Outline: Test Login with invalid Credentials
    Given I am on the login page
    When I input valid <username> and <password>
    And I click login button
    Then Invalid credentials

    Examples: 
      | username | password                 |
      | Adminnn  | hUKwJTbofgPU9eVlw/CnDQ== |
