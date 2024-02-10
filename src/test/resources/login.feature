@regression
Feature: Test Login functionality

  @smoke
  Example: User able to login successfully
    Given User is on Login Screen
    When User fills credentials username as "Akhiljda@gmail.com"
    And password is filled as "Password"
    And User click on Submit button
    Then User should be able to login