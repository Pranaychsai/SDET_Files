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
Feature: User Login

  Scenario: Title of your scenario
    Given User opens an application
    And User navigate to login page
    When User provide (username: "spy_cpy@gmail.com", password: "spy_cpy@gmail.com")
    And User clicked on submit button
    Then Myaccount page needs to be displayed
    And username should be on the page

