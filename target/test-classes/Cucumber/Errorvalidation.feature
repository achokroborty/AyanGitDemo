@tag
Feature: Error message validation
  I want to use this template for my feature file
  
  Background:
Given I landed on Ecommerce page



  @errorvalidation
  Scenario Outline: Error message Validation
    Given Logged in with <username> and <password>
    
    Then "Incorrect email or password." validate error message

    Examples: 
      | username               | password |
      | achokroborty@gmail.com | Ria@1954 |
