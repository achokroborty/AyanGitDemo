
@tag
Feature: Purchase order from Ecommerce Website

Background:
Given I landed on Ecommerce page



    
  @E2Esubmission
  Scenario Outline: End to End flow of Submitting order
    Given Logged in with <username> and <password>
    When I add <productName> in the cart
    And checkout the <productName>
    And Submit the order with <cvv> and <cardname> and <searchwords>
    Then "THANKYOU FOR THE ORDER." Validate success message

    Examples: 
      | username               | password | productName  |cvv|cardname        |searchwords|
      | achokroborty@gmail.com | Ria@1991 | ZARA COAT 3  |123|Ayan Chakraborty|IND        |
     
