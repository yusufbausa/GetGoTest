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

@tag
Feature: login

  @tag1
  Scenario Outline: login
    Given Open https://katalon-demo-cura.herokuapp.com/
  	When Click button Make Appointment and Login Succeed <username> and <password>
    And Make appointment <date> and <notes>
    Then Click back to homepage
		
    Examples: 
      | username 	| password 						| date				| notes	|
      | John Doe 	| ThisIsNotAPassword	| 01/12/2023 	| notes	|
      
      
  