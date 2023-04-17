#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login @regression
Feature: Crater app user management
  Users with permissions should be able to interact
  with the application on successful login
 
  Background: 
    Given As a user, I am on the login page
    When I enter a valid username and valid password
     And I click on login button
  @validlogin @smokeTest
  Scenario: Successful login
    When I enter a valid username and valid password
    And I click on login button
    Then I should be on user profile page

  @invalidlogin @loginTests
  Scenario: Invalid username login
    When I enter a invalid username and valid password
    And I click on login button
    Then I should see an error message
    And I should not be logged in

  @invalidPasswordLogin
  Scenario: Invalid passowrd login
    When I enter a vaid username and invalid password
    And I click on login button
    Then I should see an error message
    And I should not be logged in
    And I click on login button
  @invalidUsernameandInvalidPassword
  Scenario: Invalid username and invalid password
    When I enter invalid username and invalid password
    And I click on login button
    Then I should see an error message
    And I should not be logged in

  @createAnItemOrService
  Scenario: As a user, I am able to update an item or a service
  
    And I navigate to the Items tab
    When I click on the add Item button
    And I should be on the item input page
    When I provide item information name "Books", price "18", unit "pc", and description "a good book"
    And I click save Item button
    Then The Item is added to the Item list table

  @updateAnItemOrService
  Scenario: As a user, I am able to update an item or service
   
    And I navigate to Items tab
    When I select the Item "Books"
    And I should be on Item details page
    When I update the Item price to 30 dollars
    And I click update Item button
    Then The Item price is updated to 30 dollars
