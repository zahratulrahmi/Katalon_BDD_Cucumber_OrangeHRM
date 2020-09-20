Feature: Login Feature

  Scenario Outline: Test Login with valid Credentials
    Given I am on the login page
    When I input valid <username> and <password>
    And I click login button
    Then I should be navigated to home page

    Examples: 
      | username | password                 |
      | Admin    | hUKwJTbofgPU9eVlw/CnDQ== |

  Scenario: Check My Info menu
		When I click My Info menu
    Then I am in My Info page
    
  Scenario Outline: Add and delete Nationality
   	When I click Admin menu
    And I click Nationality menu
    And I click Add button
    And I input <name> field 
    And I click Save button
    And I check test
    Then I click Delete button
    And I click OK
    
    Examples: 
      | name 	|
      | aaaaa	|
      
  Scenario Outline: Add new employee
   	When I click PIM menu
   	And I click Add Employee menu
   	And I input <firstname> , <middlename> and <lastname>
   	And I click Save button in Add Employee page
   	Then I success add new employee
   	
   	Examples: 
      | firstname | middlename	| lastname	|
      | Test    	| Testt 			| Testt			|